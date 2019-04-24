package com.boutique.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.AdresseRepository;
import com.boutique.dao.ClientRepository;
import com.boutique.dao.CompteRepository;
import com.boutique.dao.MesureRepository;
import com.boutique.dto.AdresseDTO;
import com.boutique.dto.ClientDTODetails;
import com.boutique.dto.CompteDTO;
import com.boutique.dto.MesureDTO;
import com.boutique.dto.MesureDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.mapper.AdresseMapper;
import com.boutique.mapper.ClientMapper;
import com.boutique.mapper.CompteMapper;
import com.boutique.mapper.MesureMapper;
import com.boutique.model.Adresse;
import com.boutique.model.Client;
import com.boutique.model.Compte;
import com.boutique.model.Mesure;

@RestController
@CrossOrigin
public class ClientController {
	
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private MesureRepository mesureRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private CompteMapper compteMapper;
	@Autowired
	private MesureMapper mesureMapper;
	@Autowired 
	private AdresseMapper adresseMapper;
	
	@PostMapping(path="/saveClient")
	public ClientDTODetails saveClient(@RequestBody ClientDTODetails clientDD) {
		Client client= clientMapper.clientDTODetailsToclientDTO(clientDD);
		client.setCompte(null);
		client=clientRepository.save(client);
		if(clientDD.getCompte()!=null) {
			Compte compte= compteMapper.compteDTOToCompte(clientDD.getCompte());
			compte.setPersonne(client);
			compteRepository.save(compte);
			client.setCompte(compte);
		}
		return clientMapper.clientToClientDTODetails(client);
	}
	
	
	
	@PostMapping("/{idClient}/saveMesureClient")
	public MesureDTODetails saveMesureClient(@PathVariable long idClient,@RequestBody MesureDTO mesureDTO) {
		Optional<Client> oClient =clientRepository.findById(idClient);
		if(!oClient.isPresent())
			throw new NotExistException("Ce client n'existe pas");
		Client client =oClient.get();
		Mesure mesure=mesureMapper.mesureDTOToMesure(mesureDTO);
		for (Mesure mesure1 : client.getMesures()) {
			if(mesure.equals(mesure1)) {
				mesure=mesure1;
				break;
			}
		}
		mesure.setClient(client);
		mesure=mesureRepository.save(mesure);
		
		return mesureMapper.mesureToMesureDTODetails(mesure);
		
	}
	
	@PostMapping("/saveAdresse/{idClient}")
	public AdresseDTO saveAdresse(@PathVariable long idClient,@RequestBody AdresseDTO adresseDTO) {
		Optional<Client> oClient= clientRepository.findById(idClient);
		if(!oClient.isPresent()) {
			throw new NotExistException("Ce client n'existe pas");
		}
		Adresse adresse=adresseMapper.adresseDTOToAdresse(adresseDTO);
		adresse.setPersonne(oClient.get());
		return adresseMapper.adresseToAdresseDTO(adresseRepository.save(adresse));
	}
	
	@GetMapping("/deleteAdresse/{idAdresse}")
	public boolean deleteAddresse(@PathVariable("idAdresse") long idAdresse) {
		Optional<Adresse> oAdresse=adresseRepository.findById(idAdresse);
		if(!oAdresse.isPresent()) {
			throw new NotExistException("l'adresse n'existe pas");
		}
		
		adresseRepository.deleteById(idAdresse);
		return true;
	}
	
	@DeleteMapping(path="/deleteClient/{idClient}")
	public boolean deleteClient(@PathVariable long idClient) {
		clientRepository.deleteById(idClient);
		return true;
	}
	
	@DeleteMapping(path="/deleteClientAll")
	public boolean deleteClientAll() {
		clientRepository.deleteAll(); 
		return true;
	}
	
	@GetMapping(path="/getClientById/{idClient}")
	public ClientDTODetails getClientById(@PathVariable long idClient) {
		Optional<Client> oClient = clientRepository.findById(idClient);
		if(!oClient.isPresent()) {
			throw new NotExistException("ce client n'existe pas");
		}
		Client client=oClient.get();
		return clientMapper.clientToClientDTODetails(client);
		
	}
	
	@GetMapping(path="/getAllClient")
	public List<ClientDTODetails> getAllClient() {
		List<ClientDTODetails> list = new ArrayList<ClientDTODetails>();
		for (Client client : clientRepository.findAll()) {
			ClientDTODetails dto = clientMapper.clientToClientDTODetails(client);
			list.add(dto);
		}
		
		return list;
		
	}
	
	@GetMapping(path="/getCountClient")
	public long getCountClient() {
		return this.clientRepository.count();
	}
}

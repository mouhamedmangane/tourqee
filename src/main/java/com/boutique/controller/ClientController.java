package com.boutique.controller;

import java.util.List;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.ClientRepository;
import com.boutique.dao.CompteRepository;
import com.boutique.dto.ClientDTODetails;
import com.boutique.model.Client;
import com.boutique.model.Compte;

@RestController
@CrossOrigin
public class ClientController {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private ClientRepository clientRepository;
	
//	@Autowired
//	private MesureRepository mesureRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@PostMapping(path="/saveClient")
	public ClientDTODetails saveClient(@RequestBody ClientDTODetails clientDD) {
		Client client= modelMapper.map(clientDD,Client.class);
		client.setCompte(null);
		client=clientRepository.save(client);
		if(clientDD.getCompte()!=null) {
			Compte compte=modelMapper.map(clientDD.getCompte(),Compte.class);
			compte.setClient(client);
			compteRepository.save(compte);
			client.setCompte(compte);
		}
		return modelMapper.map(client,ClientDTODetails.class);
	}
	
//	@PostMapping("saveMesureClient")
//	public ClientDTODetails saveMesureClient(ClientDTODetails clientDD) {
//		boolean test=clientRepository.existsById(clientDD.getIdClient());
//		if(test) {
//			
//		}
//	}
	
	@GetMapping(path="/deleteClient/{idClient}")
	public boolean deleteClient(@PathVariable long idClient) {
		clientRepository.deleteById(idClient);
		return true;
	}
	
	@GetMapping(path="/getClientById/{idClient}")
	public Optional<Client> getClientById(@PathVariable long idClient) {
		return clientRepository.findById(idClient);
		
	}
	
	@GetMapping(path="/getAllClient")
	public List<Client> getAllClient() {
		return clientRepository.findAll();
		
	}
}

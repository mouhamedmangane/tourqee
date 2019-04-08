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
import com.boutique.dto.CompteDTO;
import com.boutique.dto.CompteDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.model.Compte;

@RestController
@CrossOrigin
public class CompteController {
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private ClientRepository clientRepository;
		
	
	@PostMapping(path="/connexionClient")
	public CompteDTODetails connexion(@RequestBody CompteDTO compteDTO) {
		Compte compte= modelMapper.map(compteDTO,Compte.class);
		System.out.println("comptedto");
		System.out.println(compte.getLogin());
		System.out.println(compte.getMdp());
		compte=compteRepository.connexion(compte.getLogin(),compte.getMdp());

		if(compte==null)
			throw new NotExistException("Le nom Utilisateur et le mot de passe ne correspondent pas");
		return modelMapper.map(compte,CompteDTODetails.class);
	}
	

	
	
	@PostMapping(path="/updateCompte")
	public CompteDTODetails saveCompte(@RequestBody CompteDTODetails compteDD) {
		Compte compte=modelMapper.map(compteDD, Compte.class);
		if(!clientRepository.existsById(compteDD.getClient().getIdPersonne())) {
			throw new NotExistException("client");
		}
		return modelMapper.map(compteRepository.save(compte),CompteDTODetails.class);
	}
	
	@GetMapping(path="/deleteCompte/{idCompte}")
	public boolean saveCompte(@PathVariable long idCompte) {
		compteRepository.deleteById(idCompte);
		return true;
	}
	
	@GetMapping(path="/getCompteById/{idCompte}")
	public Optional<Compte> getCompteById(@PathVariable long idCompte) {
		return compteRepository.findById(idCompte);
	}
	
	@GetMapping(path="/getAllCompte")
	public List<Compte> getCompteById() {
		return compteRepository.findAll();
	}
	
	
}

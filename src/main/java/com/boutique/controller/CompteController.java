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
import com.boutique.dao.CompteUserRepository;
import com.boutique.dto.CompteDTO;
import com.boutique.dto.CompteDTODetails;
import com.boutique.dto.CompteUserDTO;
import com.boutique.dto.CompteUserDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.model.Compte;
import com.boutique.model.CompteUser;

@RestController
@CrossOrigin
public class CompteController {
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompteUserRepository compteUserRepository;
	
	
	@PostMapping(path="/connexionClient")
	public CompteDTODetails connexion(@RequestBody CompteDTO compteDTO) {
		Compte compte= modelMapper.map(compteDTO,Compte.class);
		compte=compteRepository.connexion(compte.getLogin(),compte.getMdp());
		if(compte==null)
			throw new NotExistException("client");
		return modelMapper.map(compte,CompteDTODetails.class);
	}
	
	@PostMapping(path="/connexionUser")
	public CompteUserDTODetails connexion(@RequestBody CompteUserDTO compteUserDTO) {
		CompteUser compte= modelMapper.map(compteUserDTO,CompteUser.class);
		System.out.println(compte.getLogin()+"  "+compte.getMdp());
		compte=compteUserRepository.connexion(compte.getLogin(),compte.getMdp());
		if(compte==null)
			throw new NotExistException("compte n existe pas");
		return modelMapper.map(compte,CompteUserDTODetails.class);
	}
	
	
	@PostMapping(path="/updateCompte")
	public CompteDTODetails saveCompte(@RequestBody CompteDTODetails compteDD) {
		Compte compte=modelMapper.map(compteDD, Compte.class);
		if(!clientRepository.existsById(compteDD.getClient().getIdClient())) {
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

package com.boutique.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.CommandeRepository;
import com.boutique.model.Commande;

@RestController
public class CommandeController {
	
	@Autowired
	private CommandeRepository cr;
	
	//--------- Get List Commande ---------------
	@RequestMapping(path="/getListCommande", method=RequestMethod.GET)
	public List<Commande> getListCommande() {
		return cr.findAll();
	}
	
	//--------- Get List Etat Commande ---------------
	@RequestMapping(path="/getEtatCommande/{id}", method=RequestMethod.GET)
	public Optional<Commande> getEtatCommande(@PathVariable Long id) {
		return cr.findById(id);
	}
	
	//--------- Create Commande ---------------
	@RequestMapping(path="/saveCommande", method=RequestMethod.POST)
	public Commande saveModele(@RequestBody Commande commande) {
		return cr.save(commande);
	}
	
	//--------- Update Commande ---------------
	@RequestMapping(path="/updateEtatCommande/{id}", method=RequestMethod.PUT)
	public Commande updateEtatCommande(@RequestBody Commande commande) {
		commande.setIdCommande(commande.getIdCommande());
		return cr.save(commande);
	}
}

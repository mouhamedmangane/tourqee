package com.boutique.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.ModeleRepository;
import com.boutique.model.Modele;

@RestController
public class ModeleController {
	
	
	//------ Repository Modele
	@Autowired
	private ModeleRepository mr;
	
	//---------- Get All Modele ------------------
	@GetMapping(name="/getAllModele")
	public List<Modele> getAllModel() {		
		return mr.findAll();
	}
	
	//--------- Get Modele ---------------
	@GetMapping(path="/getModeleById/{id}")
	public Optional<Modele> getModel(@PathVariable("id") Long id) {
		return mr.findById(id);
	}
	
	//--------- Create Modele ---------------
	@PostMapping(path="/saveModele")
	public Modele saveModele(@RequestBody Modele modele) {
		return mr.save(modele);
	}
	
	//--------- Update Modele ---------------
	@PutMapping(name="/updateModele/{id}")
	public Modele updateModele(@RequestBody Modele modele) {
		modele.setIdModel(modele.getIdModel());
		return mr.save(modele);
	}
	
	//--------- Delete Modele ---------------
	@DeleteMapping(name="/deleteModele/{id}")
	public boolean deleteModele(@RequestParam Long id) {
		mr.deleteById(id);
		return true;
	}
}

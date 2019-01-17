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

import com.boutique.dao.CollectionRepository;
import com.boutique.model.Collection;

@RestController
public class CollectionController {
	
	//------ Repository Collection
	@Autowired
	private CollectionRepository cr;
	
	//---------- Get All Collection ------------------
	@GetMapping(path="/getAllCollection")
	public List<Collection> getAllModel() {		
		return cr.findAll();
	}
	
	//--------- Get Collection ---------------
	@GetMapping(path="/getCollectionById/{id}")
	public Optional<Collection> getModel(@PathVariable("id") Long id) {
		return cr.findById(id);
	}
	
	//--------- Create Collection ---------------
	@PostMapping(path="/saveCollection")
	public Collection saveModele(@RequestBody Collection collection) {
		return cr.save(collection);
	}
	
	//--------- Update Collection ---------------
	@PutMapping(path="/updateCollection/{id}")
	public Collection updateModele(@RequestBody Collection collection) {
		collection.setIdCollection(collection.getIdCollection());
		return cr.save(collection);
	}
	
	//--------- Delete Collection ---------------
	@DeleteMapping(path="/deleteCollection/{id}")
	public boolean deleteModele(@RequestParam Long id) {
		cr.deleteById(id);
		return true;
	}
}

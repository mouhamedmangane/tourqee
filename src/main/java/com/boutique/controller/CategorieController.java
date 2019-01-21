package com.boutique.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.CategoryRepository;
import com.boutique.model.Categorie;

@RestController
public class CategorieController {
	
	@Autowired
	private CategoryRepository cr;
	
	@RequestMapping(path="/saveCategory", method=RequestMethod.POST)
	public Categorie saveCategory(@RequestBody Categorie categorie) {
		return cr.save(categorie);
	}
	
	@RequestMapping(path="/getCategory/{id}", method=RequestMethod.GET)
	public Optional<Categorie> getCategory(@PathVariable Long id) {
		return cr.findById(id);
	}
	
	@RequestMapping(path="/getAllCategory", method=RequestMethod.GET)
	public List<Categorie> getAllCategory() {
		return cr.findAll();
	}

}

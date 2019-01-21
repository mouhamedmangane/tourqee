package com.boutique.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

}

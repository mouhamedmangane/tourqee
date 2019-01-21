package com.boutique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.TypeTissuRepository;
import com.boutique.model.TypeTissu;

@RestController
public class TypeTissuController {
	
	@Autowired
	private TypeTissuRepository ttr;
	
	//--------- Create Type Tissu ---------------
	@RequestMapping(path="/saveTypeTissu", method=RequestMethod.POST)
	public TypeTissu saveTypeTissu(@RequestBody TypeTissu typetissu) {
		return ttr.save(typetissu);
	}

}

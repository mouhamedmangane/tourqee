package com.boutique.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.TypeTissuRepository;
import com.boutique.dto.TypeTissuDTO;
import com.boutique.exception.ExisteDejaException;
import com.boutique.exception.NotExistException;
import com.boutique.model.TypeTissu;

@RestController
@CrossOrigin
@RequestMapping
public class TypeTissuController {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private TypeTissuRepository ttr;
	
	@PostMapping("/saveTypeTissu")
	public TypeTissuDTO saveTypeTissu(@RequestBody TypeTissuDTO typetissuD) {
		
		TypeTissu typeTissu=modelMapper.map(typetissuD,TypeTissu.class);
		if(typeTissu.getIdTypeTissu()==0) {
			Example<TypeTissu> example=Example.of(typeTissu);
			List<TypeTissu> list=ttr.findAll(example);
			if(!list.isEmpty()) {
				throw new ExisteDejaException("typeTissy");
			}
		}
		else {
			if(!ttr.existsById(typeTissu.getIdTypeTissu())) {
				throw new NotExistException("typeTissu");
			}
		}
		return modelMapper.map(ttr.save(typeTissu) ,TypeTissuDTO.class);
	}
	
	@GetMapping(path="deleteTypeTissu/{idTypeTissu}")
	public boolean deleteTissu(@PathVariable long idTypeTissu) {
		ttr.deleteById(idTypeTissu);
		return true;
	}
	
//	@GetMapping(path="/findTypeTissuByModele/{idTypeTissu}")
//	public List<TypeTissu> listTypeTissuByModele(@PathVariable long IdTypeTissu){
//		
//	}
}

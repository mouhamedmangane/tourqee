package com.boutique.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.TissuRepository;
import com.boutique.dao.TypeTissuRepository;
import com.boutique.dto.TissuDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.model.Tissu;

@RestController
@CrossOrigin
public class TissuController {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private TissuRepository tissuRepository;
	
	@Autowired
	private TypeTissuRepository typeTissuRepository;
	
	
	@PostMapping(path="/saveTissu")
	public TissuDTODetails saveTissu(@RequestBody TissuDTODetails  tissuDD) {
		Tissu tissu=modelMapper.map(tissuDD, Tissu.class);
		if(!typeTissuRepository.existsById(tissuDD.getTypeTissu().getIdTypeTissu())) {
			throw new NotExistException("tissuDD");
		}

		return modelMapper.map(tissuRepository.save(tissu), TissuDTODetails.class);
	}
	
	@GetMapping(path="deleteTissu/{idTissu}")
	public boolean deleteTissu(@PathVariable long idTissu) {
		tissuRepository.deleteById(idTissu);
		return true;
	}
	
	
}

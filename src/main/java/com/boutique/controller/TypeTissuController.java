package com.boutique.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.boutique.dto.TypeTissuDTODetails;
import com.boutique.exception.ExisteDejaException;
import com.boutique.exception.NotExistException;
import com.boutique.mesImages.PathImage;
import com.boutique.model.Preference;
import com.boutique.model.Propriete;
import com.boutique.model.Tissu;
import com.boutique.model.TypeTissu;
import com.boutique.service.FileStorageService;

@RestController
@CrossOrigin
@RequestMapping
public class TypeTissuController {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private TypeTissuRepository ttr;
	
	@Autowired
	private FileStorageService fileStorageService;
	
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
	
	@GetMapping(path="/deleteTypeTissu/{idTypeTissu}")
	public boolean deleteTissu(@PathVariable long idTypeTissu) {
		ttr.deleteById(idTypeTissu);
		return true;
	}
	
	
	@GetMapping(path="/getAllTypeTissu")
	public List<TypeTissuDTODetails> getTypeTissu() {
		List<TypeTissuDTODetails> typeTissus=new ArrayList<>();
		for (TypeTissu typeTissu : ttr.findAll()) {
			typeTissus.add(modelMapper.map(ttr.save(typeTissu) ,TypeTissuDTODetails.class));
		}
		return typeTissus;
	}
	
	@GetMapping("/deleteTypeTissu/{id}")
	public boolean deletePreference(@PathVariable long idTypeTissu) {
		Optional<TypeTissu> oTissu = ttr.findById(idTypeTissu);
		if (!oTissu.isPresent()) {
			
		}
		ttr.deleteById(idTypeTissu);
		for (Tissu tissu : oTissu.get().getTissus()) {
			fileStorageService.deleteFile(PathImage.TISSU, tissu.nameImage());
		}
		
		return true;
	}
	
	@GetMapping("/deleteAllTypeTissu")
	public boolean deletePreference() {
		
		ttr.deleteAll();
		return true;
	}

//	@GetMapping(path="/findTypeTissuByModele/{idTypeTissu}")
//	public List<TypeTissu> listTypeTissuByModele(@PathVariable long IdTypeTissu){
//		
//	}
}

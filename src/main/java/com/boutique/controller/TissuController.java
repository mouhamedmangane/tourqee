package com.boutique.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boutique.dao.TissuRepository;
import com.boutique.dao.TypeTissuRepository;
import com.boutique.dto.ProprieteDTODetails;
import com.boutique.dto.TissuDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.mesImages.PathImage;
import com.boutique.model.Propriete;
import com.boutique.model.Tissu;
import com.boutique.service.FileStorageService;

@RestController
@CrossOrigin
public class TissuController {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private TissuRepository tissuRepository;
	
	@Autowired
	private TypeTissuRepository typeTissuRepository;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping(path="/saveTissu")
	public TissuDTODetails saveTissu(@RequestBody TissuDTODetails  tissuDD) {
		Tissu tissu=modelMapper.map(tissuDD, Tissu.class);
		if(!typeTissuRepository.existsById(tissuDD.getTypeTissu().getIdTypeTissu())) {
			throw new NotExistException("tissuDD");
		}

		return modelMapper.map(tissuRepository.save(tissu), TissuDTODetails.class);
	}
	
	@PostMapping(value = "/saveTissuImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TissuDTODetails> saveProprieteImage(@RequestPart("propriete") TissuDTODetails tissuDD,
			@RequestPart("file") MultipartFile file) throws Exception  {
		System.out.println("ddsqdqsdd"+tissuDD.getTypeTissu().getIdTypeTissu());
		if (!typeTissuRepository.existsById(tissuDD.getTypeTissu().getIdTypeTissu())) {
			throw new NotExistException("Type tissu does'nt exist");
		}
		Tissu tissu=modelMapper.map(tissuDD, Tissu.class);
		tissuRepository.save(tissu);

		if (file != null) {
			fileStorageService.storeFile(file, PathImage.TISSU.toString(), tissu.nameImage());
		} else {
			System.out.println("image no saved");
		}

		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(tissu, TissuDTODetails.class));
	}
	
	@GetMapping("/deleteTissu/{idTissu}")
	public boolean deletePropriete(@PathVariable long idTissu) {
		Tissu tissu = new Tissu();
		tissu.setIdTissu(idTissu);
		if (!tissuRepository.existsById(idTissu))
			throw new NotExistException("ce propriete n existe pas");
		fileStorageService.deleteFile(PathImage.TISSU, tissu.nameImage());
		return true;
	}
	@GetMapping(path="/deleteAllTissu")
	public boolean deleteTissu() {
		tissuRepository.deleteAll();;
		return true;
	}
	

	
	
}

package com.boutique.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.MesureRepository;
import com.boutique.dto.MesureDTO;
import com.boutique.model.Mesure;
import com.boutique.model.ProprieteMesure;

@RestController
@CrossOrigin
public class MesureController {
	private static final ModelMapper modelMapper = new ModelMapper();
 
	@Autowired 
	private MesureRepository mesureRepository;
	
	@PostMapping("/saveMesure")
	public MesureDTO saveMesure(@RequestBody MesureDTO mesureDTO) {
		Mesure mesure= modelMapper.map(mesureDTO, Mesure.class);
		mesure = mesureRepository.save(mesure);
		return modelMapper.map(mesure,MesureDTO.class);
	}
	
	@GetMapping("/allProprieteMesure")
	public ProprieteMesure[] getAllPropriete(){
		return ProprieteMesure.values();
	}

}

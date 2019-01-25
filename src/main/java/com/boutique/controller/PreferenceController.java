package com.boutique.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.PreferenceRepository;
import com.boutique.dao.ProprieteRepository;
import com.boutique.dto.PreferenceDTO;
import com.boutique.dto.PreferenceDTODetails;
import com.boutique.dto.ProprieteDTO;
import com.boutique.dto.ProprieteDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.model.Preference;
import com.boutique.model.Propriete;

@RestController
@RequestMapping
@CrossOrigin
public class PreferenceController {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private PreferenceRepository pr;
	
	@Autowired
	private ProprieteRepository proprieteRepository;
	
	//--------- Create Preference ---------------
	@PostMapping("/savePreference")
	public PreferenceDTODetails savePreference(@RequestBody PreferenceDTODetails preferenceD) {
		PreferenceDTO preferenceDTO = modelMapper.map(preferenceD, PreferenceDTO .class);
		Preference preference = modelMapper.map(preferenceDTO, Preference.class);
		preference=pr.save(preference);
		if(preferenceD.getProprietes()!=null) {
			preference.setProprietes(new ArrayList<>());
			for (ProprieteDTO propD : preferenceD.getProprietes() ) {
				Propriete prop=modelMapper.map(propD, Propriete.class);
				prop.setPreference(preference);  
				preference.getProprietes().add(prop);
			} 
		}
		preference=pr.save(preference);
		return modelMapper.map(preference, PreferenceDTODetails.class);
	}
	@PostMapping("/savePropriete")
	public ProprieteDTODetails saveProprio(@RequestBody ProprieteDTODetails propDD) {
		if(pr.existsById(propDD.getPreference().getIdPreference())) {
			throw new NotExistException("preference");
		}
		Propriete propriete=modelMapper.map(propDD, Propriete.class);
		proprieteRepository.save(propriete);
		
		return modelMapper.map(propriete, ProprieteDTODetails.class);
	}
	
	@GetMapping("/deletePreference/{id}")
	public boolean deletePreference(@PathVariable long id) {
		pr.deleteById(id);
		return true;
	}
	
	
	
	@GetMapping("/getAllPreference")
	public List<PreferenceDTODetails> getAll(){
		List<Preference> listPreference=pr.findAll();
		List<PreferenceDTODetails>lsPrDD=new ArrayList<>();
		for (Preference preference : listPreference) {
			lsPrDD.add(modelMapper.map(preference, PreferenceDTODetails.class));
		}
		return lsPrDD;
	}
	
	@GetMapping("/getPreferenceById/{id}")
	public PreferenceDTODetails getPreferenceById(@PathVariable long id) {
		Optional<Preference> oPreference=pr.findById(id);
		Preference preference=null;
		if(oPreference.isPresent()) {
			preference=oPreference.get();
		}
			
		return modelMapper.map(preference, PreferenceDTODetails.class);
	}

}

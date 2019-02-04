package com.boutique.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.ConfigurationException;
import javax.servlet.MultipartConfigElement;
import javax.validation.constraints.Pattern;

import org.apache.tomcat.jni.File;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import com.boutique.dao.PreferenceRepository;
import com.boutique.dao.ProprieteRepository;
import com.boutique.dto.PreferenceDTO;
import com.boutique.dto.PreferenceDTODetails;
import com.boutique.dto.ProprieteDTO;
import com.boutique.dto.ProprieteDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.mesImages.PathImage;
import com.boutique.model.Preference;
import com.boutique.model.Propriete;
import com.boutique.service.FileStorageService;

@RestController
@CrossOrigin
public class PreferenceController {

	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private PreferenceRepository pr;

	@Autowired
	private ProprieteRepository proprieteRepository;

	@Autowired
	private FileStorageService fileStorageService;

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		return new MultipartConfigElement("");
	}



	// --------- Create Preference ---------------
	@PostMapping("/savePreference")
	public PreferenceDTODetails savePreference(@RequestBody PreferenceDTODetails preferenceD) {
		PreferenceDTO preferenceDTO = modelMapper.map(preferenceD, PreferenceDTO.class);
		Preference preference = modelMapper.map(preferenceDTO, Preference.class);
		preference = pr.save(preference);
		if (preferenceD.getProprietes() != null) {
			preference.setProprietes(new ArrayList<>());
			for (ProprieteDTO propD : preferenceD.getProprietes()) {
				Propriete prop = modelMapper.map(propD, Propriete.class);
				prop.setPreference(preference);
				preference.getProprietes().add(prop);
			}
		}
		preference = pr.save(preference);
		return modelMapper.map(preference, PreferenceDTODetails.class);
	}

	@PostMapping("/savePropriete")
	public ProprieteDTODetails saveProprio(@RequestBody ProprieteDTODetails propDD) {
		if (!pr.existsById(propDD.getPreference().getIdPreference())) {
			throw new NotExistException("preference");
		}
		Propriete propriete = modelMapper.map(propDD, Propriete.class);
		proprieteRepository.save(propriete);

		return modelMapper.map(propriete, ProprieteDTODetails.class);
	}

	@PostMapping(value = "/saveProprieteImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProprieteDTODetails> saveProprieteImage(@RequestPart("propriete") ProprieteDTODetails propDD,
			@RequestPart("file") MultipartFile file) throws Exception  {
		System.out.println("ddsqdqsdd");
		if (!pr.existsById(propDD.getPreference().getIdPreference())) {
			throw new NotExistException("preference");
		}
		Propriete propriete = modelMapper.map(propDD, Propriete.class);
		proprieteRepository.save(propriete);

		if (file != null) {
			fileStorageService.storeFile(file, PathImage.Propriete.toString(), propriete.nameImage());
		} else {
			System.out.println("image no saved");
		}

		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(propriete, ProprieteDTODetails.class));
	}

	@GetMapping("/deletePreference/{id}")
	public boolean deletePreference(@PathVariable long id) {
		Optional<Preference> oPreference = pr.findById(id);
		if (!oPreference.isPresent()) {

		}
		for (Propriete propriete : oPreference.get().getProprietes()) {
			fileStorageService.deleteFile(PathImage.Propriete, propriete.nameImage());
		}
		pr.deleteById(id);
		return true;
	}

	@GetMapping("/deleteAllPreference")
	public boolean deleteAllPreference() {
		List<Preference> listPreference = pr.findAll();
		for (Preference preference : listPreference) {
			for (Propriete propriete : preference.getProprietes()) {
				fileStorageService.deleteFile(PathImage.Propriete, propriete.nameImage());
			}
			pr.deleteById(preference.getIdPreference());
		}

		return true;
	}

	@GetMapping("/deletePropriete/{id}")
	public boolean deletePropriete(@PathVariable long id) {
		Propriete propriete = new Propriete();
		propriete.setIdPropriete(id);
		if (!proprieteRepository.existsById(id))
			throw new NotExistException("ce propriete n existe pas");
		fileStorageService.deleteFile(PathImage.Propriete, propriete.nameImage());
		return true;
	}

	@GetMapping("/getAllPreference")
	public List<PreferenceDTODetails> getAll() {
		List<Preference> listPreference = pr.findAll();
		List<PreferenceDTODetails> lsPrDD = new ArrayList<>();
		for (Preference preference : listPreference) {
			lsPrDD.add(modelMapper.map(preference, PreferenceDTODetails.class));
		}
		return lsPrDD;
	}

	@GetMapping("/getPreferenceById/{id}")
	public PreferenceDTODetails getPreferenceById(@PathVariable long id) {
		Optional<Preference> oPreference = pr.findById(id);
		Preference preference = null;
		if (oPreference.isPresent()) {
			preference = oPreference.get();
		}

		return modelMapper.map(preference, PreferenceDTODetails.class);
	}

}

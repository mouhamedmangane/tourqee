package com.boutique.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.LigneModelTissuRepository;
import com.boutique.dao.ModeleRepository;
import com.boutique.dao.PreferenceRepository;
import com.boutique.dao.TypeTissuRepository;
import com.boutique.dto.LigneModelTissuDTO;
import com.boutique.dto.ModeleDTODetails;
import com.boutique.dto.PreferenceDTO;
import com.boutique.model.LigneModelTissu;
import com.boutique.model.Modele;
import com.boutique.model.Preference;
import com.boutique.model.TypeTissu;

@RestController
public class ModeleController {
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private ModeleRepository mr;
	
	@Autowired
	PreferenceRepository preferenceRepository;
	
	@Autowired
	LigneModelTissuRepository ligneModelTissuRepository;
	
	@Autowired
	TypeTissuRepository typeTissuRepository;
	
	
	@GetMapping(name="/getAllModele")
	public List<ModeleDTODetails> getAllModel() {		
		List<ModeleDTODetails> listModele=new ArrayList<ModeleDTODetails>();
		for (Modele modele : mr.findAll()) {
			ModeleDTODetails l=modelMapper.map(modele, ModeleDTODetails.class);
			listModele.add(l);
		}
		return listModele;
	}
	
	@GetMapping(path="/getModeleById/{id}")
	public ModeleDTODetails getModel(@PathVariable("id") Long id) {
		return modelMapper.map(mr.findById(id).get(), ModeleDTODetails.class);
	}
	
	@PostMapping(path="/saveModele")
	public ModeleDTODetails saveModele(@RequestBody ModeleDTODetails modeleDTODetails) {
		 Modele model=modelMapper.map(modeleDTODetails, Modele.class);
		model=mr.save(model);
		
		//ajout preference
		if(modeleDTODetails.getPreferences()!=null) {
			model.setPreferences(new ArrayList<>());
			List<Modele> listModel=new ArrayList<>();
			listModel.add(model);
			for (PreferenceDTO prefDTO : modeleDTODetails.getPreferences()) {
				Optional<Preference> Oppref=preferenceRepository.findById(prefDTO.getIdPreference());
				Preference pref=modelMapper.map(modelMapper.map(Oppref.get(),PreferenceDTO.class),Preference.class);
				if(pref!=null) {
					
					
					System.out.println(pref.getNom()+"\n\n\n"+prefDTO.getIdPreference());
					pref.setModels(listModel);
					pref=preferenceRepository.save(pref);
					model.getPreferences().add(pref);
				}
			}
			
			
		}
		
		//ajoute ListModelTissu
		if(modeleDTODetails.getLigneModelTissus()!=null) {
			model.setLigneModelTissus(new ArrayList<>());
			for (LigneModelTissuDTO ligneDTO : modeleDTODetails.getLigneModelTissus()) {
				LigneModelTissu ligne=ligneModelTissuRepository.findByModelTissu(model.getIdModel(), ligneDTO.getTypeTissu().getIdTypeTissu());
				if(ligne !=null) {
					ligne.setPartie(ligneDTO.getPartie());
					ligneModelTissuRepository.save(ligne);
					model.getLigneModelTissus().add(ligne);
				}
				else {
					ligne=modelMapper.map(ligneDTO, LigneModelTissu.class);
					Optional<TypeTissu> typeTissu= typeTissuRepository.findById(ligne.getTypeTissu().getIdTypeTissu());
					if(typeTissu.isPresent()) {
						ligne.setTypeTissu(typeTissu.get());
						ligne.setModele(model);
						ligneModelTissuRepository.save(ligne);
						model.getLigneModelTissus().add(ligne);
					}
				}
			}
		}
		modeleDTODetails=modelMapper.map(model,ModeleDTODetails.class );
		return modeleDTODetails;
	}
	
//	@PostMapping("updatePreferences")
//	public ModeleDTODetails()
	@GetMapping("/test")

	@DeleteMapping(name="/deleteModele/{id}")
	public boolean deleteModele(@PathVariable Long id) {
		mr.deleteById(id);
		return true;
	}
}

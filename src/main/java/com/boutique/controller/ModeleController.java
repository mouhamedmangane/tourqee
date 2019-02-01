package com.boutique.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boutique.dao.CollectionRepository;
import com.boutique.dao.ImageModelesRepository;
import com.boutique.dao.LigneModelTissuRepository;
import com.boutique.dao.ModeleRepository;
import com.boutique.dao.PreferenceRepository;
import com.boutique.dao.TypeTissuRepository;
import com.boutique.dto.CollectionDTO;
import com.boutique.dto.LigneModelTissuDTO;
import com.boutique.dto.ModeleDTO;
import com.boutique.dto.ModeleDTODetails;
import com.boutique.dto.PreferenceDTO;
import com.boutique.exception.NotExistException;
import com.boutique.mesImages.PathImage;
import com.boutique.model.Collection;
import com.boutique.model.ImageModele;
import com.boutique.model.LigneModelTissu;
import com.boutique.model.Modele;
import com.boutique.model.Preference;
import com.boutique.model.Tissu;
import com.boutique.model.TypeTissu;
import com.boutique.service.FileStorageService;

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

	@Autowired
	CollectionRepository collectionRepository;

	@Autowired
	private FileStorageService fileStorageService;
	
	@Autowired
	private ImageModelesRepository imr;

	@GetMapping(name = "/getAllModele")
	public List<ModeleDTODetails> getAllModel() {
		List<ModeleDTODetails> listModele = new ArrayList<ModeleDTODetails>();
		for (Modele modele : mr.findAll()) {
			ModeleDTODetails l = modelMapper.map(modele, ModeleDTODetails.class);
			listModele.add(l);
		}
		return listModele;
	}

	@GetMapping(path = "/getModeleById/{id}")
	public ModeleDTODetails getModel(@PathVariable("id") Long id) {
		return modelMapper.map(mr.findById(id).get(), ModeleDTODetails.class);
	}

	@PostMapping(value = "/saveModeleImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModeleDTODetails saveModele(@RequestPart("modele") ModeleDTODetails modeleDTODetails,@RequestPart("images") List<MultipartFile>  files) throws Exception {
		ModeleDTO modelDTO = modelMapper.map(modeleDTODetails, ModeleDTO.class);
		Modele model = modelMapper.map(modelDTO, Modele.class);
		model = mr.save(model);
		
		try {

			if (modeleDTODetails.getCollections() != null) {
				model.setCollections(new ArrayList<>());
				for (CollectionDTO collDTO : modeleDTODetails.getCollections()) {
					model.getCollections().add(addCollection(model, collDTO.getIdCollection()));
				}

			}
			// ajout preference
			if (modeleDTODetails.getPreferences() != null) {
				model.setPreferences(new ArrayList<>());
				for (PreferenceDTO prefDTO : modeleDTODetails.getPreferences()) {
					model.getPreferences().add(addPreference(model, prefDTO.getIdPreference()));

				}

			}
			// ajoute ListModelTissu
			if (modeleDTODetails.getLigneModelTissus() != null) {
				model.setLigneModelTissus(new ArrayList<>());
				for (LigneModelTissuDTO ligneDTO : modeleDTODetails.getLigneModelTissus()) {
					LigneModelTissu ligne = modelMapper.map(ligneDTO, LigneModelTissu.class);
					model.getLigneModelTissus().add(addLigneModeleTissu(model, ligne));

				}
			}
			if (files != null) {
				model.setImages(new ArrayList<>());
				for (MultipartFile file : files) {
					ImageModele image=new ImageModele();
					image.setModele(model);
					imr.save(image);
					fileStorageService.storeFile(file, PathImage.MODELE.toString(),image.nameImage());
					model.getImages().add(image);
				}
				
			} else {
				System.out.println("image no saved");
			}
		} catch (Exception e) {
			deleteModele(model.getIdModel());
		}

		return modelMapper.map(model, ModeleDTODetails.class);
	}

	@PostMapping("/{idModele}/addPreferenceModele/{idPreference}")
	public PreferenceDTO addPreferenceModel(@PathVariable("idModele") long idModele,
			@PathVariable("idPreference") long idPref) {
		Optional<Preference> Oppref = preferenceRepository.findById(idPref);
		if (!Oppref.isPresent()) {
			throw new NotExistException("preference does not exist");
		}
		Optional<Modele> oModele = mr.findById(idModele);
		if (!oModele.isPresent()) {
			throw new NotExistException("modele " + idModele + " does not exist");
		}

//		List<Modele> list=new ArrayList<>();
//		list.add(modele);
		Preference pref = Oppref.get();
		pref.getModels().add(oModele.get());
		return modelMapper.map(preferenceRepository.save(pref), PreferenceDTO.class);
	}

	public Preference addPreference(Modele modele, long idPref) {
		Optional<Preference> Oppref = preferenceRepository.findById(idPref);
		if (!Oppref.isPresent()) {
			throw new NotExistException("preference does not exist");
		}
//		List<Modele> list=new ArrayList<>();
//		list.add(modele);
		Preference pref = Oppref.get();
		pref.getModels().add(modele);
		return preferenceRepository.save(pref);
	}

	@PostMapping("/{idModele}/addCollection/{idCollection}")
	public CollectionDTO addCollectionModele(@PathVariable long idModele, @PathVariable long idCollection) {
		Optional<Collection> Ocol = collectionRepository.findById(idCollection);
		if (!Ocol.isPresent()) {
			throw new NotExistException("collection does not exist");
		}
		Optional<Modele> oModele = mr.findById(idModele);
		if (!oModele.isPresent()) {
			throw new NotExistException("modele " + idModele + " does not exist");
		}
//		List<Modele> list=new ArrayList<>();
//		list.add(modele);
		Collection col = Ocol.get();
		col.getModels().add(oModele.get());
		return modelMapper.map(collectionRepository.save(col), CollectionDTO.class);
	}

	public Collection addCollection(Modele modele, long idCollection) {
		Optional<Collection> Ocol = collectionRepository.findById(idCollection);
		if (!Ocol.isPresent()) {
			throw new NotExistException("collection does not exist");
		}
//		List<Modele> list=new ArrayList<>();
//		list.add(modele);
		Collection pref = Ocol.get();
		pref.getModels().add(modele);
		return pref = collectionRepository.save(pref);
	}

	@PostMapping("/{idModele}/addLigneModelTissu")
	public LigneModelTissu addLigneModeleTissuModele(@PathVariable long idModele, LigneModelTissu modelTissu) {
		Optional<Modele> oModele = mr.findById(idModele);
		if (!oModele.isPresent()) {
			throw new NotExistException("modele " + idModele + " does not exist");
		}
		Optional<TypeTissu> oTtr = typeTissuRepository.findById(modelTissu.getTypeTissu().getIdTypeTissu());
		if (!oTtr.isPresent()) {
			throw new NotExistException("typeTissu does not exist");
		}
		modelTissu.setModele(oModele.get());
		modelTissu.setTypeTissu(oTtr.get());
		LigneModelTissu ligne = ligneModelTissuRepository.findByModelTissu(oModele.get().getIdModel(),
				oTtr.get().getIdTypeTissu());
		if (ligne != null) {
			modelTissu.setIdLigneModelTissu(ligne.getIdLigneModelTissu());
		}
		return ligneModelTissuRepository.save(modelTissu);
	}

	public LigneModelTissu addLigneModeleTissu(Modele modele, LigneModelTissu modelTissu) {

		Optional<TypeTissu> oTtr = typeTissuRepository.findById(modelTissu.getTypeTissu().getIdTypeTissu());
		if (!oTtr.isPresent()) {
			throw new NotExistException("typeTissu does not exist");
		}
		modelTissu.setModele(modele);
		modelTissu.setTypeTissu(oTtr.get());
		LigneModelTissu ligne = ligneModelTissuRepository.findByModelTissu(modele.getIdModel(),
				oTtr.get().getIdTypeTissu());
		if (ligne != null) {
			modelTissu.setIdLigneModelTissu(ligne.getIdLigneModelTissu());
		}
		return ligneModelTissuRepository.save(modelTissu);
	}

	@DeleteMapping("/deleteModele/{id}")
	public boolean deleteModele(@PathVariable Long id) {
		Optional<Modele> oModele=mr.findById(id);
		if (!oModele.isPresent())
			throw new NotExistException("ce propriete n existe pas");
		Modele modele = oModele.get();
		for (ImageModele image : modele.getImages()) {
			imr.deleteById(image.getIdImage());
			fileStorageService.deleteFile(PathImage.MODELE, image.nameImage());
		}
		modele.setIdModel(id);

		mr.deleteById(id);
		return true;
	}
}

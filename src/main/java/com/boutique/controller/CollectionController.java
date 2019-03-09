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

import com.boutique.dao.CollectionRepository;
import com.boutique.dao.ModeleRepository;
import com.boutique.dto.CollectionDTO;
import com.boutique.dto.CollectionDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.model.Collection;
import com.boutique.model.Modele;

@RestController

@CrossOrigin
public class CollectionController {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private CollectionRepository collectionRepository;
	
	@Autowired
	private ModeleRepository modeleRepository;
	
	@PostMapping(path="/saveCollection")
	public CollectionDTODetails saveCollection(@RequestBody CollectionDTODetails collectionDTODetails) {
		Collection collection=collectionRepository.findNomIdCategorie(collectionDTODetails.getNom(),collectionDTODetails.getCategorie().getIdCategorie());
		if(collection!=null) {
			throw   new NotExistException("Ce nom de collection existe déja dans cette categorie");

		}
		collection=modelMapper.map(collectionDTODetails, Collection.class);
		return modelMapper.map(collectionRepository.save(collection),CollectionDTODetails.class);
	}
	
	@GetMapping(path="/deleteCollection/{id}")
	public boolean deleteCollection(@PathVariable Long id) {
		 collectionRepository.deleteById(id);
		 return true;
	}
	
	@GetMapping(path="/deleteAllCollection")
	public boolean  deleteAllCollection() {
		 collectionRepository.deleteAll();
		 return true;
	}
	
	@GetMapping(path="/getCollection/{id}")
	public Optional<Collection> getCollection(@PathVariable Long id) {
		 return collectionRepository.findById(id);
	}
	
	@GetMapping(path="/getCollectionDetails/{id}")
	public CollectionDTODetails getCollectionDetails(@PathVariable Long id)  {
		Optional<Collection> collection=collectionRepository.findById(id);
		if(!collection.isPresent())
			throw new NotExistException("collection");
		return modelMapper.map(collection.get(),CollectionDTODetails.class);
		
	}
	
	@GetMapping(path="/getAllCollection")
	public List<CollectionDTO> getAllCollection() {
		List<Collection> listCollection=collectionRepository.findAll();
		List<CollectionDTO> listCollectionDTO=new ArrayList<>();
		for (Collection collection : listCollection) {
			listCollectionDTO.add(modelMapper.map(collection, CollectionDTO.class));
		}
		return listCollectionDTO;
	}
	
	@GetMapping(path="/modeleSansCollection")
	public CollectionDTODetails allwithoutCollection()  {
		Collection collection =new Collection();
		collection.setIdCollection(-1);
		collection.setNom("sans collection");
		List<Modele> list=modeleRepository.getAllModeleSansCollection();
		collection.setModels(list);

		return modelMapper.map(collection,CollectionDTODetails.class);
		
	}
	
	@GetMapping(path="/getAllModeleVide")
	public List<CollectionDTO> getAllModeleVide() {
		List<Collection> listCollection=collectionRepository.findAll();
		List<CollectionDTO> listCollectionDTO=new ArrayList<>();
		for (Collection collection : listCollection) {
			listCollectionDTO.add(modelMapper.map(collection, CollectionDTO.class));
		}
		return listCollectionDTO;
	}
	
	@GetMapping(path="/getAllCollectionDetails")
	public List<CollectionDTODetails> getAllCollectionDetails() {
		List<Collection> listCollection=collectionRepository.findAll();
		List<CollectionDTODetails> listCollectionDTODetails=new ArrayList<>();
		for (Collection collection : listCollection) {
			listCollectionDTODetails.add(modelMapper.map(collection, CollectionDTODetails.class));
		}
		return listCollectionDTODetails;
	}

}

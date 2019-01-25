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

import com.boutique.dao.CategoryRepository;
import com.boutique.dto.CategorieDTO;
import com.boutique.dto.CategorieDTODetails;
import com.boutique.exception.ExisteDejaException;
import com.boutique.exception.NotExistException;
import com.boutique.model.Categorie;

@RestController
@RequestMapping
@CrossOrigin
public class CategorieController {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping(path="/saveCategorie")
	public CategorieDTO saveCategory(@RequestBody CategorieDTO categorieDTO) {
		Categorie categorie=categoryRepository.findByNom(categorieDTO.getNom());
		if(categorie!=null) {
			throw   new ExisteDejaException("NomCategorie");

		}
		categorie=modelMapper.map(categorieDTO, Categorie.class);
		return modelMapper.map(categoryRepository.save(categorie),CategorieDTO.class);
	}
	
	@GetMapping(path="/getCategorie/{id}")
	public Optional<Categorie> getCategory(@PathVariable Long id) {
		 return categoryRepository.findById(id);
	}
	
	@GetMapping(path="/getCategorieDetails/{id}")
	public CategorieDTODetails getCategorieDetails(@PathVariable Long id)  {
		Optional<Categorie> categorie=categoryRepository.findById(id);
		if(!categorie.isPresent())
			throw new NotExistException("categorie");
		return modelMapper.map(categorie.get(),CategorieDTODetails.class);
		
	}
	
	@GetMapping(path="/getAllCategorie")
	public List<CategorieDTO> getAllCategory() {
		List<Categorie> listCategorie=categoryRepository.findAll();
		List<CategorieDTO> listCategorieDTO=new ArrayList<>();
		for (Categorie categorie : listCategorie) {
			listCategorieDTO.add(modelMapper.map(categorie, CategorieDTO.class));
		}
		return listCategorieDTO;
	}
	
	@GetMapping(path="/getAllCategorieDetails")
	public List<CategorieDTODetails> getAllCategoryDetails() {
		List<Categorie> listCategorie=categoryRepository.findAll();
		List<CategorieDTODetails> listCategorieDTODetails=new ArrayList<>();
		for (Categorie categorie : listCategorie) {
			listCategorieDTODetails.add(modelMapper.map(categorie, CategorieDTODetails.class));
		}
		return listCategorieDTODetails;
	}

}

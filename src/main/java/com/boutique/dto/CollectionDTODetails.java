package com.boutique.dto;

import java.util.Date;
import java.util.List;

public class CollectionDTODetails {
	
	private long idCollection;

	private String nom;
	
	private Date date;
	
	private CategorieDTO categorie;

	private List<ModeleDTO> models;

	public CollectionDTODetails() {
		super();
	}

	public long getIdCollection() {
		return idCollection;
	}

	public void setIdCollection(long idCollection) {
		this.idCollection = idCollection;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CategorieDTO getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieDTO categorie) {
		this.categorie = categorie;
	}

	public List<ModeleDTO> getModels() {
		return models;
	}

	public void setModels(List<ModeleDTO> models) {
		this.models = models;
	}
	
}

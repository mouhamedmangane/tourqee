package com.boutique.dto;

import java.util.Date;
import java.util.List;



public class ModeleDTODetails {
	private long idModel;
	private String nom;
	private Date date;

	private List<PreferenceDTO> preferences;
	
	private List<LigneModelTissuDTO> ligneModelTissus;

	private CollectionDTO collection;
	
	
	public ModeleDTODetails() {
		super();
	}

	public long getIdModel() {
		return idModel;
	}

	public void setIdModel(long idModel) {
		this.idModel = idModel;
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



	public List<PreferenceDTO> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<PreferenceDTO> preferences) {
		this.preferences = preferences;
	}


	public List<LigneModelTissuDTO> getLigneModelTissus() {
		return ligneModelTissus;
	}

	public void setLigneModelTissus(List<LigneModelTissuDTO> ligneModelTissus) {
		this.ligneModelTissus = ligneModelTissus;
	}

	public CollectionDTO getCollection() {
		return collection;
	}

	public void setCollection(CollectionDTO collection) {
		this.collection = collection;
	}
	
	
}

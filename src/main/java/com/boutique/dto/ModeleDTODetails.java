package com.boutique.dto;

import java.util.Date;
import java.util.List;



public class ModeleDTODetails {
	private long idModel;
	private String nom;
	private Date date;
	private String description;
	private boolean sexe;
	
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	private List<ProprieteDTODetails> proprietes;
	
	private List<LigneModelTissuDTO> ligneModelTissus;

	private List<CollectionDTO> collections;
	
	private	List<ImageModeleDTO> images;
	
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



	public List<ProprieteDTODetails> getProprietes() {
		return proprietes;
	}

	public void setProprietes(List<ProprieteDTODetails> preferences) {
		this.proprietes = preferences;
	}


	public List<LigneModelTissuDTO> getLigneModelTissus() {
		return ligneModelTissus;
	}

	public void setLigneModelTissus(List<LigneModelTissuDTO> ligneModelTissus) {
		this.ligneModelTissus = ligneModelTissus;
	}

	public List<CollectionDTO> getCollections() {
		return collections;
	}

	public void setCollections(List<CollectionDTO> collections) {
		this.collections = collections;
	}

	public List<ImageModeleDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageModeleDTO> images) {
		this.images = images;
	}


	
	
	
	
}

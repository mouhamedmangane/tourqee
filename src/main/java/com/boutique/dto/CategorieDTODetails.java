package com.boutique.dto;

import java.util.Date;
import java.util.List;


public class CategorieDTODetails {
	
	private long idCategorie;

	private String nom;
	
	private Date date;
	
	private List<CollectionDTO> collections;

	public long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
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

	public CategorieDTODetails() {
		super();
	}

	public List<CollectionDTO> getCollections() {
		return collections;
	}

	public void setCollections(List<CollectionDTO> collections) {
		this.collections = collections;
	}
	
}

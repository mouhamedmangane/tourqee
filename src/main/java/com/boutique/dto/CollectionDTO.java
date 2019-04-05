package com.boutique.dto;

import java.util.Date;


public class CollectionDTO {
	
	private long idCollection;

	private String nom;
	
	private Date date;

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

	public CollectionDTO() {
		super();
	}
	
	

}

package com.boutique.dto;

import java.util.Date;



public class CategorieDTO {
	
	private long idCategorie;

	private String nom;
	
	private Date date;

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

	public CategorieDTO() {
		super();
	}
	
	
}

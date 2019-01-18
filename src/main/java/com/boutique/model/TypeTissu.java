package com.boutique.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


public class TypeTissu {
	
	@Id
	@GeneratedValue
	private long idTypeTissue;
	
	private String nom;
	
	@OneToMany
	@JoinColumn(name="id_tissu")
	private List<Tissu> sousTypeTissu;

	public TypeTissu() {
		super();
	}

	public long getIdTypeTissue() {
		return idTypeTissue;
	}

	public void setIdTypeTissue(long idTypeTissue) {
		this.idTypeTissue = idTypeTissue;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Tissu> getSousTypeTissu() {
		return sousTypeTissu;
	}

	public void setSousTypeTissu(List<Tissu> sousTypeTissu) {
		this.sousTypeTissu = sousTypeTissu;
	}




	
	
}

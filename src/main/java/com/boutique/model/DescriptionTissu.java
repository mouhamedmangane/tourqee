package com.boutique.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DescriptionTissu {

	@Id
	@GeneratedValue
	private long idDesctiptionTissu;
	private String nom;
	
	@OneToOne
	private Tissu tissu;

	public DescriptionTissu() {
		super();
	}

	public long getIdDesctiptionTissu() {
		return idDesctiptionTissu;
	}

	public void setIdDesctiptionTissu(long idDesctiptionTissu) {
		this.idDesctiptionTissu = idDesctiptionTissu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Tissu getTissu() {
		return tissu;
	}

	public void setTissu(Tissu tissu) {
		this.tissu = tissu;
	}
	
	
}

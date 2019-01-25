package com.boutique.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class TypeTissu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idTypeTissu;
	
	private String nom;
	
	@OneToMany(mappedBy="typeTissu",cascade=CascadeType.REMOVE)
	private List<Tissu> tissus;
	
	@OneToMany(mappedBy="typeTissu",cascade=CascadeType.REMOVE)
	private List<LigneModelTissu> ligneModelTissu;

	public TypeTissu() {
		super();
	}

	public long getIdTypeTissu() {
		return idTypeTissu;
	}

	public void setIdTypeTissu(long idTypeTissu) {
		this.idTypeTissu = idTypeTissu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Tissu> getTissus() {
		return tissus;
	}

	public void setTissus(List<Tissu> tissus) {
		this.tissus = tissus;
	}

	public List<LigneModelTissu> getLigneModelTissu() {
		return ligneModelTissu;
	}

	public void setLigneModelTissu(List<LigneModelTissu> ligneModelTissu) {
		this.ligneModelTissu = ligneModelTissu;
	}







	
	
}

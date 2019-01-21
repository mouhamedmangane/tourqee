package com.boutique.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TypeTissu implements Serializable {
	
	@Id
	@GeneratedValue
	private long idTypeTissu;
	
	private String nom;
	
	@OneToMany(mappedBy="typeTissu")
	private List<Tissu> tissus;
	
	@ManyToOne
	@JoinColumn(name="id_ligne_model_tissu",insertable=false,updatable=false)
	private LigneModelTissu ligneModelTissu;

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

	public LigneModelTissu getLigneModelTissu() {
		return ligneModelTissu;
	}

	public void setLigneModelTissu(LigneModelTissu ligneModelTissu) {
		this.ligneModelTissu = ligneModelTissu;
	}






	
	
}

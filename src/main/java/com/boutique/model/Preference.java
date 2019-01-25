package com.boutique.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Preference implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long idPreference;
	private String nom;
	
	
	
	@OneToMany(mappedBy="preference",cascade=CascadeType.ALL)
	private List<Propriete> proprietes;  
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "preferences")
	private List<Modele> models;
	
	
	public Preference() {
		super();
	}

	public long getIdPreference() {
		return idPreference;
	}

	public void setIdPreference(long idPreference) {
		this.idPreference = idPreference;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}




	public List<Propriete> getProprietes() {
		return proprietes;
	}

	public void setProprietes(List<Propriete> proprietes) {
		this.proprietes = proprietes;
	}



	public List<Modele> getModels() {
		return models;
	}

	public void setModels(List<Modele> models) {
		this.models = models;
	}
	
	
	
	
	
	
}

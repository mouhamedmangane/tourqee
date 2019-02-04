package com.boutique.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Modele implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idModel;
	
	private String nom;
	
	private Date date;
	
	
	@OneToMany(mappedBy="modele",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private List<LigneModelTissu> ligneModelTissus;
	
	
	@JsonBackReference
	
	@ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
    mappedBy = "models")
	private	List<Collection> collections;
	
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	    })
	@JoinTable(name = "model_preference",
	        joinColumns = @JoinColumn(name = "id_model"),
	        inverseJoinColumns = @JoinColumn(name = "id_preference")
	    )
	 private List<Preference> preferences;
	
	
	@OneToMany(mappedBy="modele")
	private List<ImageModele> images;

	public Modele() {
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

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	
	public List<LigneModelTissu> getLigneModelTissus() {
		return ligneModelTissus;
	}

	public void setLigneModelTissus(List<LigneModelTissu> ligneModelTissus) {
		this.ligneModelTissus = ligneModelTissus;
	}
	

	public List<Preference> getPreferences() {
		return preferences;
	}



	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}
		

	public List<ImageModele> getImages() {
		return images;
	}



	public void setImages(List<ImageModele> images) {
		this.images = images;
	}



	@Override
	public String toString() {
		return "Model [idModel=" + idModel + ", nom=" + nom + ", date=" + date + ", collection=" + collections + "]";
	}

}

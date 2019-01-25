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
import javax.persistence.ManyToOne;
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
	
	
	@OneToMany(mappedBy="modele",fetch=FetchType.LAZY)
	private List<LigneModelTissu> ligneModelTissus;
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_collection",insertable=true,updatable=false)
	private Collection collection;
	
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	    })
	@JoinTable(name = "model_preference",
	        joinColumns = @JoinColumn(name = "id_model"),
	        inverseJoinColumns = @JoinColumn(name = "id_preference")
	    )
	
	 private List<Preference> preferences;

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

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
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



	@Override
	public String toString() {
		return "Model [idModel=" + idModel + ", nom=" + nom + ", date=" + date + ", collection=" + collection + "]";
	}

}

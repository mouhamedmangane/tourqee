package com.boutique.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Collection implements Serializable{
	
	@Id
	@GeneratedValue
	private long idCollection;

	@Column(name="nom")
	private String nom;
	
	@Column(name="date")
	private Date date;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categorie",insertable=true,updatable=false)
	private Categorie categorie;
	
	@JsonBackReference
	@OneToMany(mappedBy="collection",fetch=FetchType.LAZY)	
	private List<Modele> models;

	public Collection() {
		super();
	}

	public Collection(long idCollection, String nom, Date date, Categorie categorie, List<Modele> models) {
		super();
		this.idCollection = idCollection;
		this.nom = nom;
		this.date = date;
		this.categorie = categorie;
		this.models = models;
	}

	public long getIdCollection() {
		return idCollection;
	}

	public void setIdCollection(long idCollection) {
		this.idCollection = idCollection;
	}

	public String getNom() {
		return nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Modele> getModels() {
		return models;
	}

	public void setModels(List<Modele> models) {
		this.models = models;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Collection [idCollection=" + idCollection + ", nom=" + nom + ", date=" + date + ", categorie="
				+ categorie + ", models=" + models + "]";
	}

}

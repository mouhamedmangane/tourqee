package com.boutique.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue
	private long idCategorie;

	@Column(name="nom")
	private String nom;
	
	@Column(name="date")
	private Date date;
	
	@JsonBackReference
	@OneToMany(mappedBy="categorie",cascade=CascadeType.DETACH)
	private List<Collection> collection;

	public Categorie() {
		super();
	}

	public Categorie(long idCategorie, String nom, Date date, List<Collection> collection) {
		super();
		this.idCategorie = idCategorie;
		this.nom = nom;
		this.date = date;
		this.collection = collection;
	}

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

	public List<Collection> getCollection() {
		return collection;
	}

	public void setCollection(List<Collection> collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nom=" + nom + ", date=" + date + ", collection="
				+ collection + "]";
	}

}

package com.boutique.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Categorie implements Serializable{
	
	@Id
	@GeneratedValue
	private long idCategorie;

	@Column(name="nom")
	private String nom;
	
	@Column(name="date")
	private Date date;
	
	@JsonBackReference
	@OneToMany(mappedBy="categorie",fetch=FetchType.LAZY)
	private List<Collection> collections;

	public Categorie() {
		super();
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

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collection) {
		this.collections = collection;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nom=" + nom + ", date=" + date + ", collection="
				+ collections + "]";
	}

}

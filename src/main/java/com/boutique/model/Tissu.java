package com.boutique.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Tissu implements Serializable {
	
	@Id
	@GeneratedValue
	private int idTissu;
	
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="id_type_tissu",insertable=false,updatable=false)
	private TypeTissu typeTissu;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private DescriptionTissu description;
	
	
	public Tissu() {
		super();
	}
	public int getIdTissu() {
		return idTissu;
	}
	public void setIdTissu(int idTissu) {
		this.idTissu = idTissu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public TypeTissu getTypeTissu() {
		return typeTissu;
	}
	public void setTypeTissu(TypeTissu typeTissu) {
		this.typeTissu = typeTissu;
	}
	public DescriptionTissu getDescription() {
		return description;
	}
	public void setDescription(DescriptionTissu description) {
		this.description = description;
	}
	
	
}

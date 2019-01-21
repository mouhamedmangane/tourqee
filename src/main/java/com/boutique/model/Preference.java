package com.boutique.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Preference implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idPreference;
	private String nom;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private Type type;
	
	private boolean isPhoto;
	private String unite;
	
	@OneToMany(mappedBy="preference",cascade=CascadeType.REMOVE)
	List<Propriete> proprietes;   

	public Preference() {
		super();
	}

	public Long getIdPreference() {
		return idPreference;
	}

	public void setIdPreference(Long idPreference) {
		this.idPreference = idPreference;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isPhoto() {
		return isPhoto;
	}

	public void setPhoto(boolean isPhoto) {
		this.isPhoto = isPhoto;
	}

	public List<Propriete> getProprietes() {
		return proprietes;
	}

	public void setProprietes(List<Propriete> proprietes) {
		this.proprietes = proprietes;
	}
	
	
	
	
	
	
}

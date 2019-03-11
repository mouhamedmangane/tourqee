package com.boutique.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.boutique.mesImages.PathImage;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ImageModele {
	@Id
	@GeneratedValue
	private long idImage;
	
	@Transient
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="id_model",insertable=true,nullable=false)
	private Modele modele;
	
	private boolean defaut;

	public Long getIdImage() {
		return idImage;
	}
	@JsonIgnore
	public String getNom() {
		return "downloadFile/"+PathImage.MODELE.toString()+"/"+nameImage();
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}

	public ImageModele() {
		super();
	}

	public boolean isDefaut() {
		return defaut;
	}

	public void setDefaut(boolean defaut) {
		this.defaut = defaut;
	}

	public void setIdImage(long idImage) {
		this.idImage = idImage;
	}
	
	@JsonIgnore
	public String nameImage() {
		return getIdImage()+".jpg";
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}
	
	
	

	
	
}

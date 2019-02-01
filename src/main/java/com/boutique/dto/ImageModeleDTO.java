package com.boutique.dto;



public class ImageModeleDTO {
	
	private long idImage;
	private String nom;
	private boolean defaut;
	
	
	public ImageModeleDTO() {
		super();
	}

	public long getIdImage() {
		return idImage;
	}

	public void setIdImage(long idImage) {
		this.idImage = idImage;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isDefaut() {
		return defaut;
	}

	public void setDefaut(boolean defaut) {
		this.defaut = defaut;
	}
	
	
	
	
}

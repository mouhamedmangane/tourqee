package com.boutique.dto;


public class TissuDTODetails {
	
	private long idTissu;
	
	private String nom;
	
	private TypeTissuDTO typeTissu;
	
	

	public TissuDTODetails() {
		super();
	}

	public long getIdTissu() {
		return idTissu;
	}

	public void setIdTissu(long idTissu) {
		this.idTissu = idTissu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeTissuDTO getTypeTissu() {
		return typeTissu;
	}

	public void setTypeTissu(TypeTissuDTO typeTissu) {
		this.typeTissu = typeTissu;
	}



	
	

}

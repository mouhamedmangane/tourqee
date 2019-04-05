package com.boutique.dto;

public class DescriptionTissuDTODetails {
	private long idDescriptionTissu;
	private String nom;
	private TissuDTO tissu;

	public DescriptionTissuDTODetails() {
		super();
	}
	public long getIdDescriptionTissu() {
		return idDescriptionTissu;
	}
	public void setIdDescriptionTissu(long idDescriptionTissu) {
		this.idDescriptionTissu = idDescriptionTissu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public TissuDTO getTissu() {
		return tissu;
	}
	public void setTissu(TissuDTO tissu) {
		this.tissu = tissu;
	}
	
	
}

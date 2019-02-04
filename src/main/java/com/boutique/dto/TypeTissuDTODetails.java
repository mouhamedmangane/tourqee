package com.boutique.dto;

import java.util.List;

public class TypeTissuDTODetails {

	private long idTypeTissu;
	
	private String nom;
	
	private List<TissuDTO> tissus;

	



	public TypeTissuDTODetails() {
		super();
	}


	public long getIdTypeTissu() {
		return idTypeTissu;
	}


	public void setIdTypeTissu(long idTypeTissu) {
		this.idTypeTissu = idTypeTissu;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<TissuDTO> getTissus() {
		return tissus;
	}


	public void setTissus(List<TissuDTO> tissus) {
		this.tissus = tissus;
	}



	
	
}

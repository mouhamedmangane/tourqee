package com.boutique.dto;

import java.util.List;

public class PreferenceDTODetails {
	
	private long idPreference;
	
	private String nom;
	


	private List<ProprieteDTO> proprietes; 


	public PreferenceDTODetails() {
		super();
	}


	public long getIdPreference() {
		return idPreference;
	}


	public void setIdPreference(long idPreference) {
		this.idPreference = idPreference;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}





	public List<ProprieteDTO> getProprietes() {
		return proprietes;
	}


	public void setProprietes(List<ProprieteDTO> proprietes) {
		this.proprietes = proprietes;
	}



	


	
	
}

package com.boutique.dto;

import java.util.List;

public class PreferenceDTODetails {
	
	private Long idPreference;
	
	private String nom;
	


	private List<ProprieteDTO> proprietes; 


	public PreferenceDTODetails() {
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





	public List<ProprieteDTO> getProprietes() {
		return proprietes;
	}


	public void setProprietes(List<ProprieteDTO> proprietes) {
		this.proprietes = proprietes;
	}



	


	
	
}

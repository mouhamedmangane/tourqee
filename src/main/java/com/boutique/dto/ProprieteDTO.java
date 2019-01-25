package com.boutique.dto;

import java.util.List;


import com.boutique.model.LignePropriete;

public class ProprieteDTO {

	private long idPropriete;
	
	private String valeur;

	private Long preference;

	public ProprieteDTO() {
		super();
	}

	public long getIdPropriete() {
		return idPropriete;
	}

	public void setIdPropriete(long idPropriete) {
		this.idPropriete = idPropriete;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}



	public Long getPreference() {
		return preference;
	}

	public void setPreference(Long preference) {
		this.preference = preference;
	}

	public List<LignePropriete> getLigneProprietes() {
		return ligneProprietes;
	}

	public void setLigneProprietes(List<LignePropriete> ligneProprietes) {
		this.ligneProprietes = ligneProprietes;
	}

	private List<LignePropriete> ligneProprietes;

}

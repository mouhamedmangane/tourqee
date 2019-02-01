package com.boutique.dto;


public class ProprieteDTODetails {
	
	private long idPropriete;
	
	private String valeur;

	private PreferenceDTO preference;
	
	private String image;

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

	public PreferenceDTO getPreference() {
		return preference;
	}

	public void setPreference(PreferenceDTO preference) {
		this.preference = preference;
	}

	public ProprieteDTODetails() {
		super();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}

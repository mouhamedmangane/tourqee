package com.boutique.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.boutique.model.LignePropriete;

public class ProprieteDTOInputImage {
	private long idPropriete;
	
	private String valeur;

	private PreferenceDTO preference;
	
	private MultipartFile image;

	public ProprieteDTOInputImage() {
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



	public PreferenceDTO getPreference() {
		return preference;
	}

	public void setPreference(PreferenceDTO preference) {
		this.preference = preference;
	}

	public List<LignePropriete> getLigneProprietes() {
		return ligneProprietes;
	}

	public void setLigneProprietes(List<LignePropriete> ligneProprietes) {
		this.ligneProprietes = ligneProprietes;
	}

	private List<LignePropriete> ligneProprietes;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
}

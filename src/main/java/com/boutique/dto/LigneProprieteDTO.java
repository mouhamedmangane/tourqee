package com.boutique.dto;

import com.boutique.model.LigneProprietePK;

public class LigneProprieteDTO {
	
	private LigneProprietePK lignePropiretePK;

	private Long produit;

	private Long propriete;

	public LigneProprieteDTO() {
		super();
	}

	public LigneProprietePK getLignePropiretePK() {
		return lignePropiretePK;
	}

	public void setLignePropiretePK(LigneProprietePK lignePropiretePK) {
		this.lignePropiretePK = lignePropiretePK;
	}

	public Long getProduit() {
		return produit;
	}

	public void setProduit(Long produit) {
		this.produit = produit;
	}

	public Long getPropriete() {
		return propriete;
	}

	public void setPropriete(Long propriete) {
		this.propriete = propriete;
	}
	
	

}

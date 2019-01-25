package com.boutique.dto;

import com.boutique.model.LigneProprietePK;

public class LigneProprieteDTODetails {
	
	private LigneProprietePK lignePropiretePK;

	private ProduitDTO produit;

	private ProprieteDTODetails propriete;

	public LigneProprieteDTODetails() {
		super();
	}

	public LigneProprietePK getLignePropiretePK() {
		return lignePropiretePK;
	}

	public void setLignePropiretePK(LigneProprietePK lignePropiretePK) {
		this.lignePropiretePK = lignePropiretePK;
	}



	public ProduitDTO getProduit() {
		return produit;
	}

	public void setProduit(ProduitDTO produit) {
		this.produit = produit;
	}

	public ProprieteDTODetails getPropriete() {
		return propriete;
	}

	public void setPropriete(ProprieteDTODetails propriete) {
		this.propriete = propriete;
	}


	
	
	
}

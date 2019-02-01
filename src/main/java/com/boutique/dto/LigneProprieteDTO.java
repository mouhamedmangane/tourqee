package com.boutique.dto;

import com.boutique.model.LigneProprietePK;

public class LigneProprieteDTO {
	
	private LigneProprietePK lignePropiretePK;


	private ProprieteDTODetails propriete;

	public LigneProprieteDTO() {
		super();
	}

	public LigneProprietePK getLignePropiretePK() {
		return lignePropiretePK;
	}

	public void setLignePropiretePK(LigneProprietePK lignePropiretePK) {
		this.lignePropiretePK = lignePropiretePK;
	}



	public ProprieteDTODetails getPropriete() {
		return propriete;
	}

	public void setPropriete(ProprieteDTODetails  propriete) {
		this.propriete = propriete;
	}
	
	

}

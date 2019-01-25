package com.boutique.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LignePropriete implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LigneProprietePK lignePropiretePK;

	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="id_produit",insertable=false,updatable=false)
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="id_propriete",insertable=false,updatable=false)
	private Propriete propriete;

	public LigneProprietePK getLignePropiretePK() {
		return lignePropiretePK;
	}

	public void setLignePropiretePK(LigneProprietePK lignePropiretePK) {
		this.lignePropiretePK = lignePropiretePK;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Propriete getPropriete() {
		return propriete;
	}

	public void setPropriete(Propriete propriete) {
		this.propriete = propriete;
	}
	
}

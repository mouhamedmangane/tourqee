package com.boutique.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LigneCommande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idLigneCommande;
	
	private int quantite;
	
	private double prix;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="id_produit",nullable=true,insertable=true)
	private Produit produit;
	
	
	@ManyToOne()
	@JoinColumn(name="id_commande",insertable=true,updatable=true,nullable=true)
	private Commande commande;
	
	
	
	public LigneCommande() {
		super();
	}

	public long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", quantite=" + quantite + ", prix=" + prix
				+ ", produit=" + produit + ", commande=" + commande + "]";
	}
	
	
	
}

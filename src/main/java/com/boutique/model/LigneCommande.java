package com.boutique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable{
	@Id
	@GeneratedValue
	private long idLigneCommande;
	
	private int quantite;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="id_produit",nullable=false,insertable=true)
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="id_commande")
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
	
	
	
}

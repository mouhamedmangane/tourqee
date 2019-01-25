package com.boutique.dto;


public class LigneCommandeDTODetais {
	
	private long idLigneCommande;
	
	private int quantite;
	
	private double prix;
	
	private ProduitDTODetails produit;
	


	public LigneCommandeDTODetais() {
		super();
	}


	public long getIdLigneCommande() {
		return idLigneCommande;
	}


	public void setIdLigneCommande(long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
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


	public ProduitDTODetails getProduit() {
		return produit;
	}


	public void setProduit( ProduitDTODetails produit) {
		this.produit = produit;
	}



	
	

}

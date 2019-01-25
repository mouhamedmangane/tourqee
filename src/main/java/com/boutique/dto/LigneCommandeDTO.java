package com.boutique.dto;



import com.boutique.model.Produit;

public class LigneCommandeDTO {

	private long idLigneCommande;
	
	private int quantite;
	
	private double prix;
	
	private Produit produit;
	
	private Long commande;



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


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public Long getCommande() {
		return commande;
	}


	public void setCommande(Long commande) {
		this.commande = commande;
	}


	public LigneCommandeDTO() {
		super();
	}


	


	
	
}

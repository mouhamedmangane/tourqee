package com.boutique.dto;



import com.boutique.model.Produit;

public class LigneCommandeDTO {

	private long idLigneCommande;
	
	private int quantite;
	
	private double prix;
	
	private Produit produit;
	
	private CommandeDTOSimple commande;



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


	public CommandeDTOSimple getCommande() {
		return commande;
	}


	public void setCommande(CommandeDTOSimple commande) {
		this.commande = commande;
	}


	public LigneCommandeDTO() {
		super();
	}


	


	
	
}

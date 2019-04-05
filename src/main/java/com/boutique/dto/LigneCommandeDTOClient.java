package com.boutique.dto;

public class LigneCommandeDTOClient {
	private long idLigneCommande;
	
	private int quantite;
	
	private ModeleDTO model;

	public LigneCommandeDTOClient() {
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

	public ModeleDTO getModel() {
		return model;
	}

	public void setModel(ModeleDTO modele) {
		this.model = modele;
	}
	
	
	
}

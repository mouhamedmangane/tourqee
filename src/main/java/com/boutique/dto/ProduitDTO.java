package com.boutique.dto;


public class ProduitDTO {

	private long idProduit;

	private ModeleDTO modele;
	
	
		
	public ProduitDTO() {
		super();
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}



	public ModeleDTO getModele() {
		return modele;
	}

	public void setModele(ModeleDTO modele) {
		this.modele = modele;
	}

	


	

}
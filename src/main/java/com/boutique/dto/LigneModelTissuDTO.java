package com.boutique.dto;


public class LigneModelTissuDTO {
	

	private long idLigneModelTissu;
	
	
	private ModeleDTO modele;
	

	private TypeTissuDTO typeTissu;


	public long getIdLigneModelTissu() {
		return idLigneModelTissu;
	}


	public void setIdLigneModelTissu(long idLigneModelTissu) {
		this.idLigneModelTissu = idLigneModelTissu;
	}





	public ModeleDTO getModele() {
		return modele;
	}


	public void setModele(ModeleDTO modele) {
		this.modele = modele;
	}


	public TypeTissuDTO getTypeTissu() {
		return typeTissu;
	}


	public void setTypeTissu(TypeTissuDTO typeTissu) {
		this.typeTissu = typeTissu;
	}


	public LigneModelTissuDTO() {
		super();
	}
	
	

}

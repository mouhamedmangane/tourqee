package com.boutique.dto;


import java.util.List;


public class CommandeDTOSave {

	private ClientDTO client;

	private List<LigneCommandeDTODetais> ligneCommandes;




	public List<LigneCommandeDTODetais> getLigneCommandes() {
		return ligneCommandes;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public void setLigneCommandes(List<LigneCommandeDTODetais> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public CommandeDTOSave() {
		super();
	}
	
	
}

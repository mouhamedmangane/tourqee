package com.boutique.dto;

import java.util.List;

public class CommandeDTOClient {
	
	private long idCommande;
	private ClientDTO client;
	private List<LigneCommandeDTOClient> ligneCommandes;
	
	public CommandeDTOClient() {
		super();
	}
	public long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}
	public ClientDTO getClient() {
		return client;
	}
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	public List<LigneCommandeDTOClient> getLigneCommandes() {
		return ligneCommandes;
	}
	public void setLigneCommandes(List<LigneCommandeDTOClient> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
	
	
}

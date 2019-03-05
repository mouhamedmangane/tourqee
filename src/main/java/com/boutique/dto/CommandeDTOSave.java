package com.boutique.dto;


import java.util.Date;
import java.util.List;


public class CommandeDTOSave {

	private ClientDTO client;

	private List<LigneCommandeDTODetais> ligneCommandes;

	private Date dateFin;


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

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
	
	
}

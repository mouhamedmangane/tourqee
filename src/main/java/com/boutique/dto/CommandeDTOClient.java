package com.boutique.dto;

import java.util.Date;
import java.util.List;

public class CommandeDTOClient {
	
	private long idCommande;
	private ClientDTO client;
	private Date dateDebut;

	private Date dateFin;
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
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
	
}

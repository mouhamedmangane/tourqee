package com.boutique.dto;

import java.util.Date;
import java.util.List;

import com.boutique.model.EtatCommande;


public class CommandeDTODetails {
	private long idCommande;

	private Date dateDebut;

	private Date dateFin;
	
	private EtatCommande etatCommande;
	
	private boolean archiver;

	private ClientDTO client;

	private List<LigneCommandeDTODetais> ligneCommandes;
	
	
	public CommandeDTODetails() {
		super();
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
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

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public List<LigneCommandeDTODetais> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommandeDTODetais> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public EtatCommande getEtatCommande() {
		return etatCommande;
	}
	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}
	
	
	
}

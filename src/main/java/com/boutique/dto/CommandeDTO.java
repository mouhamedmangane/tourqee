package com.boutique.dto;

import java.util.Date;
import java.util.List;

import com.boutique.model.EtatCommande;
import com.boutique.model.LigneCommande;

public class CommandeDTO {

	private long idCommande;

	private Date dateDebut;

	private Date dateFin;
	private EtatCommande etatCommande;


	private List<LigneCommande> ligneCommandes;

	public CommandeDTO() {
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



	public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}



	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
	

}

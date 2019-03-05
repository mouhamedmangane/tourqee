package com.boutique.dto;

import java.util.Date;
import java.util.List;

import com.boutique.model.LigneCommande;

public class CommandeDTOSimple {

	private long idCommande;

	private Date dateDebut;

	private Date dateFin;
	private boolean etatCommande;



	public CommandeDTOSimple() {
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

	public boolean isEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(boolean etatCommande) {
		this.etatCommande = etatCommande;
	}

	
}


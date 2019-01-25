package com.boutique.dto;

import com.boutique.model.ProprieteMesure;

public class LigneMesureDTO {
	
	private long idLigneMesure;
	
	private ProprieteMesure proprieteMesure;
	
	private double valeur;

	public LigneMesureDTO() {
		super();
	}


	public long getIdLigneMesure() {
		return idLigneMesure;
	}


	public void setIdLigneMesure(long idLigneMesure) {
		this.idLigneMesure = idLigneMesure;
	}


	public ProprieteMesure getProprieteMesure() {
		return proprieteMesure;
	}

	public void setProprieteMesure(ProprieteMesure proprieteMesure) {
		this.proprieteMesure = proprieteMesure;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	
	
	
	
	
	
}

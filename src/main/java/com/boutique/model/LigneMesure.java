package com.boutique.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LigneMesure {
	
	@EmbeddedId
	private LigneMesurePK ligneMesurePK;
	
	private double valeur;

	public LigneMesure() {
		super();
	}

	public LigneMesurePK getLigneMesurePK() {
		return ligneMesurePK;
	}

	public void setLigneMesurePK(LigneMesurePK ligneMesurePK) {
		this.ligneMesurePK = ligneMesurePK;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	
	
}

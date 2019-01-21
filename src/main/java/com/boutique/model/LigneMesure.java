package com.boutique.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneMesure implements Serializable {
	
	@EmbeddedId
	private LigneMesurePK ligneMesurePK;
	
	@ManyToOne
	@JoinColumn(name="id_mesure",insertable=false,updatable=false)
	private Mesure mesure;
	

	
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

	public Mesure getMesure() {
		return mesure;
	}

	public void setMesure(Mesure mesure) {
		this.mesure = mesure;
	}
	
	
	
}

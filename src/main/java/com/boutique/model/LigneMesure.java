package com.boutique.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
        name="ligne_mesure", 
        uniqueConstraints= @UniqueConstraint(columnNames={"propriete_mesure", "id_mesure"})
        )
public class LigneMesure implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	private long idLigneMesure;
	

	@Column(name = "propriete_mesure")
	@Enumerated(EnumType.STRING)
	private ProprieteMesure proprieteMesure;
	
	private double valeur;
	
	@ManyToOne
	@JoinColumn(name="id_mesure",insertable=true,updatable=false)
	private Mesure mesure;
	

	
	

	public LigneMesure() {
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

	public Mesure getMesure() {
		return mesure;
	}

	public void setMesure(Mesure mesure) {
		this.mesure = mesure;
	}
	
	
	
}

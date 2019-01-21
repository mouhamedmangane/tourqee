package com.boutique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Propriete implements Serializable {
	
	@Id
	@GeneratedValue
	private long idPropriete;
	
	private String valeur;
	
	@ManyToOne
	@JoinColumn(name="id_preference")
	private Preference preference;
	
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;

	public Propriete() {
		super();
	}

	public long getIdPropriete() {
		return idPropriete;
	}

	public void setIdPropriete(long idPropriete) {
		this.idPropriete = idPropriete;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
}

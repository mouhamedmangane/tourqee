package com.boutique.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Produit {
	@Id
	@GeneratedValue
	private Produit idProduit;
	
	@ManyToOne
	@JoinColumn(name="id_modele")
	private Modele modele;
	
	@ManyToOne
	@JoinColumn(name="id_tissu")
	private Tissu tissu;
	
	@ManyToOne
	@JoinColumn(name="mesure")
	private Mesure mesure;
	
	@OneToMany(mappedBy="produit")
	private List<Propriete> proprietes;

	public Produit() {
		super();
	}

	public Produit getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Produit idProduit) {
		this.idProduit = idProduit;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Tissu getTissu() {
		return tissu;
	}

	public void setTissu(Tissu tissu) {
		this.tissu = tissu;
	}

	public Mesure getMesure() {
		return mesure;
	}

	public void setMesure(Mesure mesure) {
		this.mesure = mesure;
	}

	public List<Propriete> getProprietes() {
		return proprietes;
	}

	public void setProprietes(List<Propriete> proprietes) {
		this.proprietes = proprietes;
	}
	
	
}

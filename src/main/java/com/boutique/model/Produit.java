package com.boutique.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Produit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idProduit;
	
	@ManyToOne
	@JoinColumn(name="id_modele")
	private Modele modele;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.REMOVE
            })
    @JoinTable(name = "tissu_produit",
            joinColumns = { @JoinColumn(name = "id_produit") },
            inverseJoinColumns = { @JoinColumn(name = "id_tissu") })
	private List<Tissu> tissus;
	
	@ManyToOne
	@JoinColumn(name="mesure",nullable=true)
	private Mesure mesure;
	
	@OneToMany(mappedBy="produit",cascade=CascadeType.REMOVE)
	private List<LignePropriete> ligneProprietes;

	public Produit() {
		super();
	}



	public long getIdProduit() {
		return idProduit;
	}



	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}



	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}



	public List<Tissu> getTissus() {
		return tissus;
	}



	public void setTissus(List<Tissu> tissus) {
		this.tissus = tissus;
	}



	public Mesure getMesure() {
		return mesure;
	}

	public void setMesure(Mesure mesure) {
		this.mesure = mesure;
	}

	public List<LignePropriete> getLigneProprietes() {
		return ligneProprietes;
	}

	public void setLigneProprietes(List<LignePropriete> proprietes) {
		this.ligneProprietes = proprietes;
	}



	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", modele=" + modele + ", tissus=" + tissus + ", mesure=" + mesure
				+ ", proprietes=" + ligneProprietes + "]";
	}
	
	
}

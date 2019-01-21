package com.boutique.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class LigneModelTissu implements Serializable {

	@Id
	@GeneratedValue
	private long idLigneModelTissu;
	private int partie;
	
	@ManyToOne
	@JoinColumn(name="id_model")
	private Modele modele;
	
	@OneToMany(mappedBy="ligneModelTissu")
	private List<TypeTissu> typeTissus;

	public LigneModelTissu() {
		super();
	}

	public long getIdLigneModelTissu() {
		return idLigneModelTissu;
	}

	public void setIdLigneModelTissu(long idLigneModelTissu) {
		this.idLigneModelTissu = idLigneModelTissu;
	}

	public int getPartie() {
		return partie;
	}

	public void setPartie(int partie) {
		this.partie = partie;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public List<TypeTissu> getTypeTissus() {
		return typeTissus;
	}

	public void setTypeTissus(List<TypeTissu> typeTissus) {
		this.typeTissus = typeTissus;
	}
	
	
	
	
	
}

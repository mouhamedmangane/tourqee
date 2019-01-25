package com.boutique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity

public class LigneModelTissu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long idLigneModelTissu;
	private int partie;
	
	@ManyToOne
	@JoinColumn(name="id_modele")
	private Modele modele;
	
	@ManyToOne
	@JoinColumn(name="id_type_tissu")
	private TypeTissu typeTissu;

	
	
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

	public TypeTissu getTypeTissu() {
		return typeTissu;
	}

	public void setTypeTissu(TypeTissu typeTissu) {
		this.typeTissu = typeTissu;
	}
	
	
	
	
	
}

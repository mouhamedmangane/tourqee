package com.boutique.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
        name="propriete", 
        uniqueConstraints= @UniqueConstraint(columnNames={"valeur", "id_preference"})
        )
public class Propriete implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idPropriete;
	
	private String valeur;
	
	@ManyToOne
	@JoinColumn(name="id_preference")
	private Preference preference;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//            },
//            mappedBy = "proprietes")
	
	@OneToMany(mappedBy="propriete")
	private List<LignePropriete> ligneProprietes;

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

	public List<LignePropriete> getLigneProprietes() {
		return ligneProprietes;
	}

	public void setLigneProprietes(List<LignePropriete> produits) {
		this.ligneProprietes = produits;
	}


	
	
	
}

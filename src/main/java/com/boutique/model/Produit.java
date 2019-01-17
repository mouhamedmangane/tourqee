package com.boutique.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Produit {
	@Id
	@GeneratedValue
	private Produit idProduit;
	@ManyToOne
	@JoinColumn(name="id_modele")
	private Modele modele;
	private Tissu tissu;
	private List<Propriete> tissus;
}

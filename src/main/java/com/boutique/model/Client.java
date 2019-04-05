package com.boutique.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_client")
public class Client extends Personne {

	@OneToMany(mappedBy="client")
	private List<Mesure> mesures;
	
	@OneToMany(mappedBy="client",cascade=CascadeType.REMOVE)
	private List<Commande> commandes;

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<Mesure> getMesures() {
		return mesures;
	}

	public void setMesures(List<Mesure> mesures) {
		this.mesures = mesures;
	}

	public Client() {
		super();
	}
}

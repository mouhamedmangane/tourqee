package com.boutique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idCompte;
	
	@NotNull
	private String login;
	
	@NotNull
	private String mdp;
	
	@OneToOne(  fetch = FetchType.LAZY)
	@JoinColumn(name = "id_personne")
	private Personne personne;
	
	

	public Compte() {
		super();
	}

	public long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(long idCompte) {
		this.idCompte = idCompte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}




	
	
}

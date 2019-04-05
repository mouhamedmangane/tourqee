package com.boutique.dto;

public class CompteDTODetails {
	
	private long idCompte;
	
	private String login;
	
	private String mdp;
	
	private PersonneDTO personne;

	public CompteDTODetails() {
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

	public PersonneDTO getClient() {
		return personne;
	}

	public void setPersonne(PersonneDTO client) {
		this.personne = client;
	}
	
	
}

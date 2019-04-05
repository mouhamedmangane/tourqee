package com.boutique.dto;


public class CompteDTO {

	private long idCompte;
	
	private String login;
	
	private String mdp;
	
	private PersonneDTO personne;

	public CompteDTO() {
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

	public PersonneDTO getPersonne() {
		return personne;
	}

	public void setPersonne(PersonneDTO personne) {
		this.personne = personne;
	}
	
	
}

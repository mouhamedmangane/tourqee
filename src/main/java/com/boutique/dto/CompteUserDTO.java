package com.boutique.dto;

public class CompteUserDTO {
	
	private long idCompteUser;
	
	private String login;
	
	private String mdp;

	
	
	public CompteUserDTO() {
		super();
	}

	public long getIdCompteUserUser() {
		return idCompteUser;
	}

	public void setIdCompteUserUser(long idCompteUserUser) {
		this.idCompteUser = idCompteUserUser;
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
	
	
}

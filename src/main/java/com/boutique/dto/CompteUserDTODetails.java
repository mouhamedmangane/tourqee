package com.boutique.dto;

public class CompteUserDTODetails {
	
	private long idCompteUser;
	
	private String login;
	
	private String mdp;
	
	private UserDTO user;

	public CompteUserDTODetails() {
		super();
	}

	public long getIdCompteUser() {
		return idCompteUser;
	}

	public void setIdCompteUser(long idCompteUser) {
		this.idCompteUser = idCompteUser;
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}


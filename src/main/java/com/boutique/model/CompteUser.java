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
public class CompteUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idCompteUser;
	
	@NotNull
	private String login;
	
	@NotNull
	private String mdp;

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user",nullable=true,updatable=true)
	private User user;

	public CompteUser() {
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



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	
}

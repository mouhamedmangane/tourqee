package com.boutique.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long idUser;
	private String nom;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private CompteUser compteUser;
	
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE,
	    })
	@JoinTable(name = "user_role",
		    joinColumns = { @JoinColumn(name = "id_user") },
		    inverseJoinColumns = { @JoinColumn(name = "id_role") })
	private List<Role> roles;

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long id) {
		this.idUser = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CompteUser getCompteUser() {
		return compteUser;
	}

	public void setCompteUser(CompteUser compteUser) {
		this.compteUser = compteUser;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User() {
		super();
	}
	
	
	
	
	
}

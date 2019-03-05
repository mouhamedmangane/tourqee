package com.boutique.dto;

import java.util.List;

public class RoleDTODetails {
	
	private long idRole;
	
	private String nom;
	
	private List<UserDTO> users;

	public RoleDTODetails() {
		super();
	}

	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
}

package com.boutique.dto;

import java.util.List;

public class UserDTODetails {
	
	
	private long idUser;
	
	private String nom;
	
	private CompteUserDTO compteUser;
	
	private List<RoleDTO> roles;

	public UserDTODetails() {
		super();
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CompteUserDTO getCompteUser() {
		return compteUser;
	}

	public void setCompteUser(CompteUserDTO compte) {
		this.compteUser = compte;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	
}

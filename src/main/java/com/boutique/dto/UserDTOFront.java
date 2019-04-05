package com.boutique.dto;

import java.util.List;

public class UserDTOFront extends PersonneDTODetails {
	private List<String> roles;

	public List<String> getRoles() {
		return roles;
	}

	public UserDTOFront() {
		super();
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}

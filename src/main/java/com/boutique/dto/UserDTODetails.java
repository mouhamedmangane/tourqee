package com.boutique.dto;

import java.util.List;

public class UserDTODetails extends PersonneDTODetails {
	
	
	
	private List<RoleDTO> roles;

	public UserDTODetails() {
		super();
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	
}

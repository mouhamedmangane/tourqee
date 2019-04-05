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
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_user")
public class User extends Personne {
	@ManyToMany(fetch = FetchType.LAZY,
		    cascade = {
		        CascadeType.PERSIST,
		        CascadeType.MERGE
		    })
	@JoinTable(name = "user_role",
		    joinColumns = { @JoinColumn(name = "id_user") },
		    inverseJoinColumns = { @JoinColumn(name = "id_role") })
	private List<Role> roles;

	
	public User() {
		super();
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
}

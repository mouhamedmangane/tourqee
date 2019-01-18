package com.boutique.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Tissu {
	
	private int idTissu;
	private String nom;
	private TypeTissu typeTissu;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private DescriptionTissu description;
	

}

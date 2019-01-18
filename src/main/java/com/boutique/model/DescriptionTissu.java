package com.boutique.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DescriptionTissu {

	@Id
	@GeneratedValue
	private long idDesctiptionTissu;
	private String nom;
	
	@OneToOne
	private Tissu tissu;
}

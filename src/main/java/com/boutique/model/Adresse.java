package com.boutique.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue
	private Long idAdresse;
	
	private int numero;
	
	private String telephone;
	
	private String ville;
	
	private String pays;
	
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
}

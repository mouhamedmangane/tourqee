package com.boutique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;



@Entity
public class Adresse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idAdresse;
	
	@NotNull
	private int numero;
	
	
	private String telephone;
	
	@NotNull
	private String villa;
	
	@NotNull
	private String pays;
	
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;


	public Long getIdAdresse() {
		return idAdresse;
	}


	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getVille() {
		return villa;
	}


	public void setVille(String ville) {
		this.villa = ville;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	
}

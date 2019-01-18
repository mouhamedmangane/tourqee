package com.boutique.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Mesure {
	
	@Id
	@GeneratedValue
	private long idMesure;
	
	private String nom;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@OneToMany(mappedBy="ligneMesures")
	private List<LigneMesure> ligneMesures;

	public Mesure() {
		super();
	}

	public long getIdMesure() {
		return idMesure;
	}

	public void setIdMesure(long idMesure) {
		this.idMesure = idMesure;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneMesure> getLigneMesures() {
		return ligneMesures;
	}

	public void setLigneMesures(List<LigneMesure> ligneMesures) {
		this.ligneMesures = ligneMesures;
	}
	
	
	
	
}
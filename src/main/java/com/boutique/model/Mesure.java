package com.boutique.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Mesure implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idMesure;
	
	private String nom;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@OneToMany(mappedBy="mesure",fetch=FetchType.LAZY)
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
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idMesure ^ (idMesure >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesure other = (Mesure) obj;
		if (idMesure!=0 && idMesure == other.idMesure )
			return true;
		else {
			for (LigneMesure ligneMesure : other.ligneMesures) {
				for (LigneMesure ligneMesure2 : ligneMesures) {
					if(ligneMesure.getProprieteMesure().equals(ligneMesure2) && ligneMesure.getValeur()!=ligneMesure2.getValeur()) {
						return false;
					}
				}
			}
		}
		return true;
	}


	
	
	
	
}

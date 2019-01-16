package com.boutique.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Model implements Serializable {
	
	@Id
	@GeneratedValue
	private long idModel;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id_collection")
	private Collection collection;

	public Model() {
		super();
	}

	public Model(long idModel, String nom, Date date, Collection collection) {
		super();
		this.idModel = idModel;
		this.nom = nom;
		this.date = date;
		this.collection = collection;
	}

	public long getIdModel() {
		return idModel;
	}

	public void setIdModel(long idModel) {
		this.idModel = idModel;
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

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "Model [idModel=" + idModel + ", nom=" + nom + ", date=" + date + ", collection=" + collection + "]";
	}

}

package com.boutique.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idPersonne;
	
	@NotNull
	private String nom;
	
	private String prenom;
	
	private String mail;
	
	private boolean sexe;
	
	@NotNull
	private String telephone;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@OneToMany(mappedBy="personne",cascade = CascadeType.REMOVE)
	private List<Adresse> adresses;
	

	
	
	
	

	@OneToOne(mappedBy="personne",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Compte compte;
	
	public Personne() {
		super();
	}

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}





	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" +       idPersonne + ", nom=" + nom + ", Prenom=" + prenom + ", mail=" + mail
				+ ", telephone=" + telephone + ", dateCreation=" + dateCreation + ", adresses=" + adresses
				+ ", mesures="  + ", compte=" + compte + "]";
	}
	
	
	

}

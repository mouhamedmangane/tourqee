package com.boutique.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idClient;
	
	@NotNull
	private String nom;
	
	private String prenom;
	
	private String mail;
	
	@NotNull
	private String telephone;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@OneToMany(mappedBy="client",cascade = CascadeType.REMOVE)
	private List<Adresse> adresses;
	
	@OneToMany(mappedBy="client")
	private List<Mesure> mesures;
	
	
	@OneToMany(mappedBy="client",cascade=CascadeType.REMOVE)
	private List<Commande> commandes;
	

	@OneToOne(mappedBy="client",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Compte compte;
	
	public Client() {
		super();
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
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

	public List<Mesure> getMesures() {
		return mesures;
	}

	public void setMesures(List<Mesure> mesures) {
		this.mesures = mesures;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
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
		return "Client [idClient=" +       idClient + ", nom=" + nom + ", Prenom=" + prenom + ", mail=" + mail
				+ ", telephone=" + telephone + ", dateCreation=" + dateCreation + ", adresses=" + adresses
				+ ", mesures=" + mesures + ", commandes=" + commandes + ", compte=" + compte + "]";
	}
	
	
	

}

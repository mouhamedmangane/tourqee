package com.boutique.dto;

import java.util.Date;
import java.util.List;

public class PersonneDTODetails {
	private long idPersonne;

	private String nom;
	
	private String prenom;
	
	private String mail;

	private String telephone;
	
	private boolean sexe;
	
	private Date dateCreation;
	
	private List<AdresseDTO> adresses;
	
	private List<MesureDTO> mesures;
	
	//private List<CommandeDTO> commandes;
	
	private CompteDTO compte;
	
	
	
	public PersonneDTODetails() {
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

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<AdresseDTO> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<AdresseDTO> adresses) {
		this.adresses = adresses;
	}

	public List<MesureDTO> getMesures() {
		return mesures;
	}

	public void setMesures(List<MesureDTO> mesures) {
		this.mesures = mesures;
	}

	//public List<CommandeDTO> getCommandes() {
		//return commandes;
	//}

//	public void setCommandes(List<CommandeDTO> commandes) {
//		this.commandes = commandes;
//	}

	public CompteDTO getCompte() {
		return compte;
	}

	public void setCompte(CompteDTO compte) {
		this.compte = compte;
	}
	
	
	
}

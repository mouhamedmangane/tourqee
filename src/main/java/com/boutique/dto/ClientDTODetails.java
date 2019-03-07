package com.boutique.dto;

import java.util.Date;
import java.util.List;



public class ClientDTODetails {
	
	private long idClient;
	
	private String nom;
	
	private String prenom;
	
	private String mail;
	
	private String telephone;
	
	private Date dateCreation;
	
	
	private List<AdresseDTO> adresses;
	
	private List<MesureDTO> mesures;
	
	private List<CommandeDTODetails> commandes;
	
	
	private CompteDTO compte;

	public ClientDTODetails() {
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

	public List<CommandeDTODetails> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<CommandeDTODetails> commandes) {
		this.commandes = commandes;
	}

	public CompteDTO getCompte() {
		return compte;
	}

	public void setCompte(CompteDTO compte) {
		this.compte = compte;
	}
	

	
}

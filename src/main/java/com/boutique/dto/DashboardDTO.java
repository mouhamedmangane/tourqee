package com.boutique.dto;

public class DashboardDTO{
	private long nbrCommandeEnCours;
	private long nbrCommandeEnAttente;
	private long nbrCommandeTermine;
	private long nbrCommandeLivre;
	
	private long nbrModele;
	private long nbrModeleSansCollection;
	private long nbrCollection;
	private long nbrCategorie;
	
	private long nbrClient;
	
	public DashboardDTO(long nbrCommandeEnCours, long nbrCommandeEnAttente, long nbrCommandeTermine,
			long nbrCommandeLivre, long nbrModele, long nbrModeleSansCollection, long nbrCollection,
			long nbrCategorie,long nbrCllient) {
		super();
		this.nbrCommandeEnCours = nbrCommandeEnCours;
		this.nbrCommandeEnAttente = nbrCommandeEnAttente;
		this.nbrCommandeTermine = nbrCommandeTermine;
		this.nbrCommandeLivre = nbrCommandeLivre;
		this.nbrModele = nbrModele;
		this.nbrModeleSansCollection = nbrModeleSansCollection;
		this.nbrCollection = nbrCollection;
		this.nbrCategorie = nbrCategorie;
		this.nbrClient=nbrClient;
	}
	public long getNbrClient() {
		return nbrClient;
	}
	public void setNbrClient(long nbrClient) {
		this.nbrClient = nbrClient;
	}
	public DashboardDTO() {
		super();
	}
	public long getNbrCommandeEnCours() {
		return nbrCommandeEnCours;
	}
	public void setNbrCommandeEnCours(long nbrCommandeEnCours) {
		this.nbrCommandeEnCours = nbrCommandeEnCours;
	}
	public long getNbrCommandeEnAttente() {
		return nbrCommandeEnAttente;
	}
	public void setNbrCommandeEnAttente(long nbrCommandeEnAttente) {
		this.nbrCommandeEnAttente = nbrCommandeEnAttente;
	}
	public long getNbrCommandeTermine() {
		return nbrCommandeTermine;
	}
	public void setNbrCommandeTermine(long nbrCommandeTermine) {
		this.nbrCommandeTermine = nbrCommandeTermine;
	}
	public long getNbrCommandeLivre() {
		return nbrCommandeLivre;
	}
	public void setNbrCommandeLivre(long nbrCommandeLivre) {
		this.nbrCommandeLivre = nbrCommandeLivre;
	}
	public long getNbrModele() {
		return nbrModele;
	}
	public void setNbrModele(long nbrModele) {
		this.nbrModele = nbrModele;
	}
	public long getNbrModeleSansCollection() {
		return nbrModeleSansCollection;
	}
	public void setNbrModeleSansCollection(long nbrModeleSansCollection) {
		this.nbrModeleSansCollection = nbrModeleSansCollection;
	}
	public long getNbrCollection() {
		return nbrCollection;
	}
	public void setNbrCollection(long nbrCollection) {
		this.nbrCollection = nbrCollection;
	}
	public long getNbrCategorie() {
		return nbrCategorie;
	}
	public void setNbrCategorie(long nbrCategorie) {
		this.nbrCategorie = nbrCategorie;
	}
	
	
}

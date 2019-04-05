package com.boutique.dto;



public class AdresseDTO {

	private Long idAdresse;
	

	private int numero;
	
	
	private String telephone;
	

	private String villa;
	 

	private String pays;
	

	private ClientDTO client;
	
	

	public AdresseDTO() {
		super();
	}


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


	public String getVilla() {
		return villa;
	}


	public void setVilla(String villa) {
		this.villa = villa;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public ClientDTO getClient() {
		return client;
	}


	public void setClient(ClientDTO client) {
		this.client = client;
	}
	
	
}

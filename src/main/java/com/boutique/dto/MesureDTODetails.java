package com.boutique.dto;

import java.util.Date;
import java.util.List;

public class MesureDTODetails {
	private long idMesure;
	

	private Date date;

	
	private List<LigneMesureDTO> ligneMesures;
	
	private ClientDTO client;



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

	public List<LigneMesureDTO> getLigneMesures() {
		return ligneMesures;
	}

	public void setLigneMesures(List<LigneMesureDTO> ligneMesures) {
		this.ligneMesures = ligneMesures;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}
	

}

package com.boutique.dto;

import java.util.Date;
import java.util.List;




public class MesureDTO {

	private long idMesure;
	

	private Date date;

	
	private List<LigneMesureDTO> ligneMesures;

	public MesureDTO() {
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

	public List<LigneMesureDTO> getLigneMesures() {
		return ligneMesures;
	}

	public void setLigneMesures(List<LigneMesureDTO> ligneMesures) {
		this.ligneMesures = ligneMesures;
	}




	

	
	

}

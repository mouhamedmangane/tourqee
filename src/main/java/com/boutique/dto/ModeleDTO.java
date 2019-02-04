package com.boutique.dto;

import java.util.Date;
import java.util.List;





public class ModeleDTO {
	
	private long idModel;
	private String nom;
	private Date date;
	
	private List<ImageModeleDTO> images;

	public ModeleDTO() {
		super();
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



	public List<ImageModeleDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageModeleDTO> images) {
		this.images = images;
	}


	

	
	
	
	
}

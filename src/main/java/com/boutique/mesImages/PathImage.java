package com.boutique.mesImages;

public enum PathImage {
	Propriete("propriete"), MODELE("model"),TISSU("tissu");
	
	private String value;
	
	private PathImage(String value) {
		this.value=value;
	}
	
	public String toString() {
		return this.value;
	}
}

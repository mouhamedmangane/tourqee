package com.boutique.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LigneProprietePK implements Serializable{


	private static final long serialVersionUID = 1L;

	@Column(name="id_produit")
	private long idProduit;
	
	@Column(name="id_propriete")
	private long idPropriete;

	public LigneProprietePK() {
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public long getIdPropriete() {
		return idPropriete;
	}

	public void setIdPropriete(long idPropriete) {
		this.idPropriete = idPropriete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idProduit ^ (idProduit >>> 32));
		result = prime * result + (int) (idPropriete ^ (idPropriete >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneProprietePK other = (LigneProprietePK) obj;
		if (idProduit != other.idProduit)
			return false;
		if (idPropriete != other.idPropriete)
			return false;
		return true;
	}
	
	
}

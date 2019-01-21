package com.boutique.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class LigneMesurePK implements Serializable{
	
	@Column(name = "id_mesure")
	private long idMesure;
	
	@Column(name = "proprete_mesure")
	@Enumerated(EnumType.STRING)
	private ProprieteMesure proprieteMesure;
	
	
	public LigneMesurePK() {
		super();
	}
	public long getIdMesure() {
		return idMesure;
	}
	public void setIdMesure(long idMesure) {
		this.idMesure = idMesure;
	}
	public ProprieteMesure getProprieteMesure() {
		return proprieteMesure;
	}
	public void setProprieteMesure(ProprieteMesure proprieteMesure) {
		this.proprieteMesure = proprieteMesure;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idMesure ^ (idMesure >>> 32));
		result = prime * result + ((proprieteMesure == null) ? 0 : proprieteMesure.hashCode());
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
		LigneMesurePK other = (LigneMesurePK) obj;
		if (idMesure != other.idMesure)
			return false;
		if (proprieteMesure != other.proprieteMesure)
			return false;
		return true;
	}
	
	
}

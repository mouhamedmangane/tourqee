package com.boutique.dto;

import java.util.List;

public class ProduitDTODetails {
	private long idProduit;

	private ModeleDTO modele;
	
	private List<TissuDTODetails> tissus;
	
	private MesureDTO mesure;
	
	private List<LigneProprieteDTODetails>  ligneProprietes;

	public long getIdProduit() {
		return idProduit;
	}
	
	
	public ProduitDTODetails() {
		super();
	}


	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public ModeleDTO getModele() {
		return modele;
	}

	public void setModele(ModeleDTO modele) {
		this.modele = modele;
	}



	public List<TissuDTODetails> getTissus() {
		return tissus;
	}


	public void setTissus(List<TissuDTODetails> tissus) {
		this.tissus = tissus;
	}


	public MesureDTO getMesure() {
		return mesure;
	}

	public void setMesure(MesureDTO mesure) {
		this.mesure = mesure;
	}

	public List<LigneProprieteDTODetails> getLigneProprietes() {
		return ligneProprietes;
	}

	public void setLigneProprietes(List<LigneProprieteDTODetails> ligneProprietes) {
		this.ligneProprietes = ligneProprietes;
	}
	
	
}

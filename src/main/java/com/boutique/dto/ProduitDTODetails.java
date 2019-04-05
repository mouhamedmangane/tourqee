package com.boutique.dto;

import java.util.List;

public class ProduitDTODetails {
	
	private long idProduit;

	private ModeleDTO modele;
	
	private List<TissuDTODetails> tissus;
	
	private MesureDTODetails mesure;
	
	private List<ProprieteDTO>  proprietes;

	
	
	public ProduitDTODetails() {
		super();
	}
	
	public long getIdProduit() {
		return idProduit;
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


	public MesureDTODetails getMesure() {
		return mesure;
	}

	public void setMesure(MesureDTODetails mesure) {
		this.mesure = mesure;
	}


	public List<ProprieteDTO> getProprietes() {
		return proprietes;
	}


	public void setProprietes(List<ProprieteDTO> proprietes) {
		this.proprietes = proprietes;
	}

	
	
	
}

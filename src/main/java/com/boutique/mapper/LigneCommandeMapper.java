package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.LigneCommandeDTO;
import com.boutique.dto.LigneCommandeDTOClient;
import com.boutique.dto.LigneCommandeDTODetais;
import com.boutique.model.LigneCommande;
import com.boutique.model.Modele;
import com.boutique.model.Produit;

@Mapper(componentModel="spring",uses= {CommandeMapper.class,ProduitMapper.class})
public interface LigneCommandeMapper {
	LigneCommandeMapper INSTANCE = Mappers.getMapper(LigneCommandeMapper.class);
	
	public LigneCommandeDTO ligneCommandeToLigneCommandeDTO(LigneCommande ligneCommande);
	public LigneCommande ligneCommandeDTOToLigneCommande(LigneCommandeDTO ligneCommandeDTO);
	
	public LigneCommandeDTODetais ligneCommandeToLigneCommandeDTODetais(LigneCommande ligneCommande);
	public LigneCommande ligneCommandeDTODetaisToLigneCommande(LigneCommandeDTODetais ligneCommandeDTODetais);
	
	default LigneCommande ligneCommandeDTOClientToLigneCommande(LigneCommandeDTOClient ligneCommandeDTOClient) {
		LigneCommande ligneCommande=new LigneCommande();
		ligneCommande.setIdLigneCommande(ligneCommandeDTOClient.getIdLigneCommande());
		ligneCommande.setQuantite(ligneCommandeDTOClient.getQuantite());
		Produit p=new Produit();
		Modele modele=ModeleMapper.INSTANCE.modeleDTOToModele(ligneCommandeDTOClient.getModel());
		p.setModele(modele);
		ligneCommande.setProduit(p);
		return ligneCommande;
	}
	
	
	
}

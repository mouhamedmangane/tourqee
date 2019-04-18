package com.boutique.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.ImageModeleDTO;
import com.boutique.dto.LigneCommandeDTO;
import com.boutique.dto.LigneCommandeDTOClient;
import com.boutique.dto.LigneCommandeDTODetais;
import com.boutique.dto.ModeleDTO;
import com.boutique.model.ImageModele;
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
	default LigneCommandeDTOClient ligneCommandeToLigneCommandeDTOClient(LigneCommande ligneCommande) {
		LigneCommandeDTOClient dtoClient=new LigneCommandeDTOClient();
		dtoClient.setIdLigneCommande(ligneCommande.getIdLigneCommande());
		dtoClient.setQuantite(ligneCommande.getQuantite());
		ModeleDTO modeleDTO=ModeleMapper.INSTANCE.modeleToModeleDTO(ligneCommande.getProduit().getModele());
		List<ImageModeleDTO> images= new ArrayList<ImageModeleDTO>();
		for (ImageModele imageModele : ligneCommande.getProduit().getModele().getImages()) {
			ImageModeleDTO image=new ImageModeleDTO();
			image.setNom(imageModele.getNom());
			images.add(image);
		}
		modeleDTO.setImages(images);
		dtoClient.setModel(modeleDTO);
		return dtoClient;
	}
	
	
	
}

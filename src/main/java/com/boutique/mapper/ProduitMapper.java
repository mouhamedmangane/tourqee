package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.ProduitDTO;
import com.boutique.dto.ProduitDTODetails;
import com.boutique.model.Produit;

@Mapper(componentModel="spring",uses= {MesureMapper.class,ProprieteMapper.class,ModeleMapper.class,TissuMapper.class})
public interface ProduitMapper {
	ProduitMapper INSTANCE = Mappers.getMapper(ProduitMapper.class);

	ProduitDTO produitToProduitDTO(Produit produit);
	Produit produitDTOToProduit(ProduitDTO produitDTO);
	
	ProduitDTODetails produitToProduitDTODetails(Produit produit);
	Produit produitDTODetailsToProduit(ProduitDTODetails produitDTODetails);
}

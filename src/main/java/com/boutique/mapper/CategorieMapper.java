package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.CategorieDTO;
import com.boutique.dto.CategorieDTODetails;
import com.boutique.model.Categorie;

@Mapper(componentModel="spring",uses={CollectionMapper.class})
public interface CategorieMapper {
	
	CategorieMapper INSTANCE = Mappers.getMapper(CategorieMapper.class);
	
	CategorieDTO categorieToCategorieDTO (Categorie categorie);
	Categorie categorieDTOTOCatgorie(CategorieDTO categoirie);
	
	CategorieDTODetails categorieToCategoriDTODetails(Categorie categoirie);
	Categorie categorieTOCategorieDTODetails(CategorieDTODetails categorieDTODetails);

	
	
	
}

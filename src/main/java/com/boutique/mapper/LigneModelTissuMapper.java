package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.LigneModelTissuDTO;
import com.boutique.dto.TypeTissuDTO;
import com.boutique.model.LigneModelTissu;

@Mapper(componentModel="spring",uses= {TypeTissuMapper.class,ModeleMapper.class})
public interface LigneModelTissuMapper {
	LigneModelTissuMapper INSTANCE=Mappers.getMapper(LigneModelTissuMapper.class);
	
	LigneModelTissuDTO ligneModelTisuToLigneModelTissuDTO(LigneModelTissu ligneModelTissu);
	
	LigneModelTissu ligneModelTissuDTOToLigneModelTissu(LigneModelTissuDTO ligneModelTissu);
	
	default TypeTissuDTO ligneModelTissuToTissu(LigneModelTissuDTO ligneModelTissu) {
		return ligneModelTissu.getTypeTissu();
	}

	
	

}

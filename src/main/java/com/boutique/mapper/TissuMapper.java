package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.TissuDTO;
import com.boutique.dto.TissuDTODetails;
import com.boutique.model.Tissu;

@Mapper(componentModel="spring",uses= {ProduitMapper.class,TypeTissuMapper.class,DescriptionTissuMapper.class})
public interface TissuMapper {
	TissuMapper INSTANCE = Mappers.getMapper(TissuMapper.class);
	
	TissuDTO tissToTissuDTO(Tissu tissu);
	Tissu tissuDTOToTissu(TissuDTO tissuDTO);
	
	TissuDTODetails tissuToTissuDTODetails(Tissu tissu);
	Tissu tissuDTODetailsToTissu(TissuDTODetails tissuDTODetails);
}

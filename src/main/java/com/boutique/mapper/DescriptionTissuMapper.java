package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.DescriptionTissuDTO;
import com.boutique.dto.DescriptionTissuDTODetails;
import com.boutique.model.DescriptionTissu;

@Mapper(componentModel="spring",uses={TissuMapper.class})
public interface DescriptionTissuMapper {
	DescriptionTissuMapper INSTANCE= Mappers.getMapper(DescriptionTissuMapper.class);
	
	DescriptionTissuDTO DescriptionTissuToDescriptionTissuDTO(DescriptionTissu descriptionTissu);
	DescriptionTissu descriptionTissuDTOToDescriptionTissu(DescriptionTissu descriptionTissuDTO);
	
	DescriptionTissuDTODetails desctiptionTodescriptionDTODetails(DescriptionTissu descriptionTissu);
	DescriptionTissu descriptionTissuDTODetailsToDescriptionTissu(DescriptionTissuDTODetails desciptionTissuDTODetails);
}

package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.TypeTissuDTO;
import com.boutique.dto.TypeTissuDTODetails;
import com.boutique.model.TypeTissu;

@Mapper(componentModel="spring",uses= {TissuMapper.class})
public interface TypeTissuMapper {
	TypeTissuMapper INSTANCE  = Mappers.getMapper(TypeTissuMapper.class);
	
	TypeTissuDTO typeTissuToTypeTissuDTO(TypeTissu typeTissu);
	TypeTissu typeTissuDTOToTypeTissu(TypeTissuDTO TypeTissuDTO);
	
	TypeTissuDTODetails typeTissuToTypeTissuDTODetails(TypeTissu typeTissu);
	TypeTissu typeTissuDTOToTypeTissu(TypeTissu typeTissu);
	
}

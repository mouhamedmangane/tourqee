package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.LigneMesureDTO;
import com.boutique.model.LigneMesure;


@Mapper(componentModel="spring")
public interface LigneMesureMapper {
	LigneMesureMapper INSTANCE= Mappers.getMapper(LigneMesureMapper.class);
	
	public LigneMesureDTO ligneMesureToLigneMesureDTO(LigneMesure ligneMesure);
	public LigneMesure ligneMesureDTOToLigneMesure(LigneMesureDTO ligneMesureDTO);
	
}

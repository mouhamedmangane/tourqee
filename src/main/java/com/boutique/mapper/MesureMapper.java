package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.LigneMesureDTO;
import com.boutique.dto.MesureDTO;
import com.boutique.dto.MesureDTODetails;
import com.boutique.model.LigneMesure;
import com.boutique.model.Mesure;

@Mapper(componentModel="spring",uses= {LigneMesureMapper.class,ClientMapper.class})
public interface MesureMapper {
	MesureMapper INSTANCE= Mappers.getMapper(MesureMapper.class);
	
	MesureDTO mesureToMesureDTO(Mesure mesure);
	Mesure mesureDTOToMesure(MesureDTO mesureDTO);
	
	
	MesureDTODetails mesureToMesureDTODetails(Mesure mesure);
	Mesure mesureDTODetailsToMesure(MesureDTODetails mesureDTODetails);
	

	
}
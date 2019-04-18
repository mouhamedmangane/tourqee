package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.ImageModeleDTO;
import com.boutique.model.ImageModele;

@Mapper(componentModel = "spring")
public interface ImageModeleMapper {
	
	ImageModeleMapper INSTANCE= Mappers.getMapper(ImageModeleMapper.class);
	@Mapping(target="defaut",ignore=true)
	ImageModeleDTO imageModeleTOImageModeleDTO(ImageModele imageModele);
	
 	ImageModele imageModeleDTOToImageModele(ImageModeleDTO imageModeleDTO);
}

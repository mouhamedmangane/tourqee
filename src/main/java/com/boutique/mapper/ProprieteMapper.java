package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.ProprieteDTO;
import com.boutique.dto.ProprieteDTODetails;
import com.boutique.model.Propriete;

@Mapper(componentModel="spring",uses= {PreferenceMapper.class})
public interface ProprieteMapper {
	ProprieteMapper INSTANCE = Mappers.getMapper(ProprieteMapper.class);
	
	ProprieteDTO prorprieteToProprieteDTO(Propriete propriete);
	Propriete proprieteDTOToPropriete(ProprieteDTO proprieteDTO);
	
	ProprieteDTODetails proprieteToProprieteDTODetails(Propriete propriete);
	Propriete proprieteDTODetailsToPropriete(ProprieteDTODetails proprieteDTODetails);
	
	ProprieteDTO proprietDTODetailsToProprieteDTO(ProprieteDTODetails proprieteDTODetails);
	ProprieteDTODetails proprieteDTOToProprieteDTO(ProprieteDTO proprieteDTO);
	
}

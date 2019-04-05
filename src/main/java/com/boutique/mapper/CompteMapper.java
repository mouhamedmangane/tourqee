package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.CompteDTO;
import com.boutique.dto.CompteDTODetails;
import com.boutique.model.Compte;

@Mapper(componentModel="spring",uses={PersonneMapper.class})
public interface CompteMapper {
	
	CompteMapper INSTANCE= Mappers.getMapper(CompteMapper.class);
	
	public CompteDTO  compteToCompteDTO(Compte compte); 
	public Compte compteDTOToCompte(CompteDTO compteDTO);
	
	public CompteDTODetails compteToCompteDTODetails(Compte compte);
	public Compte compteDTODetailsToCompte(Compte compte);
}

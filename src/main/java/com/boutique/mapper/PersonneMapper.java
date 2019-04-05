package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.PersonneDTO;
import com.boutique.dto.PersonneDTODetails;
import com.boutique.model.Personne;

@Mapper(componentModel="spring",uses ={MesureMapper.class,AdresseMapper.class,CommandeMapper.class,CompteMapper.class})
public interface PersonneMapper {
	PersonneMapper INSTANCE  = Mappers.getMapper(PersonneMapper.class);
	
	PersonneDTO personneToPersonneDTO(Personne personne);
	Personne personneDTOPersonne(PersonneDTO personneDTO);
	
	PersonneDTODetails personneToPersonneDTODetails(Personne personne);
	Personne personneDTODetailsToPersonne(PersonneDTODetails personne);
}

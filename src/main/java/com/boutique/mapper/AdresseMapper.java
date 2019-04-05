package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.AdresseDTO;
import com.boutique.dto.ClientDTO;
import com.boutique.model.Adresse;
import com.boutique.model.Client;

@Mapper(componentModel="spring")
public interface AdresseMapper {
	AdresseMapper INSTANCE = Mappers.getMapper(AdresseMapper.class);
	
	public AdresseDTO adresseToAdresseDTO(Adresse adresse);
	public Adresse adresseDTOToAdresse(AdresseDTO adresseDTO);
	
	public ClientDTO clientToClientDTO(Client client);
	
	
}

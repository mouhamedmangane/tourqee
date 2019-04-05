package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.ClientDTO;
import com.boutique.dto.ClientDTODetails;
import com.boutique.model.Client;

@Mapper(componentModel="spring",uses= {PersonneMapper.class,AdresseMapper.class,MesureMapper.class,CommandeMapper.class,CompteMapper.class})
public interface ClientMapper {
	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
	
	ClientDTO clientToClientDTO(Client  client);
	Client clientDTODetails(ClientDTO clientDTO);
	
	Client clientDTODetailsToclientDTO(ClientDTODetails clientDTODetails);
	ClientDTODetails clientToClientDTODetails(Client client);
}

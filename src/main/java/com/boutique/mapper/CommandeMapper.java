package com.boutique.mapper;

import java.util.ArrayList;
import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.CommandeDTO;
import com.boutique.dto.CommandeDTOClient;
import com.boutique.dto.CommandeDTODetails;
import com.boutique.dto.CommandeDTOSave;
import com.boutique.dto.CommandeDTOSimple;
import com.boutique.model.Commande;

@Mapper (componentModel="spring", uses= {ClientMapper.class,LigneCommandeMapper.class})
public interface  CommandeMapper {
	CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);
	
	CommandeDTO commaneToCommandeDTO(Commande commande);
	Commande commandeDTOCommande(CommandeDTO commandeDTO);
	
	CommandeDTODetails commaneToCommandeDTODetails(CommandeDTODetails commande);
	Commande commandeDTODetailsCommande(CommandeDTODetails commandeDTO);
	
	
	CommandeDTOSave commandeToCommandeDtoSave(Commande commande);
	Commande commandeDTOSaveToCommande(CommandeDTOSave commandeDTOSave);
	
	CommandeDTOSimple commandeToCommandeDtoSimple(Commande commande);
	Commande commandeDTOSimpleToCommande(CommandeDTOSimple commandeDTOSimple);
	
	Commande commandeDTOClientToCommande(CommandeDTOClient commandeDTOClient);
	
	
	
	
}

package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.CollectionDTO;
import com.boutique.dto.CollectionDTODetails;
import com.boutique.model.Collection;

@Mapper(componentModel="spring",uses={CategorieMapper.class,ModeleMapper.class})
public interface  CollectionMapper {
	
	CollectionMapper INSTANCE = Mappers.getMapper(CollectionMapper.class);
	
	CollectionDTODetails collectionToCollectionDTODetails(Collection categoirie);
	Collection collecitonTOCollectionDTODetails(CollectionDTODetails CollectionDTODetails);
	
	CollectionDTO collectionToCollectionDTO(Collection collection);
	Collection collectionDTOToCollection(CollectionDTO collectionDTO);
	
}

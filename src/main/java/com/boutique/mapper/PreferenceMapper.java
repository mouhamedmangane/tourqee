package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.PreferenceDTO;
import com.boutique.dto.PreferenceDTODetails;
import com.boutique.model.Preference;

@Mapper(componentModel="spring",uses= {ProprieteMapper.class})
public interface PreferenceMapper {
	PreferenceMapper INSTANCE = Mappers.getMapper(PreferenceMapper.class);
	
	PreferenceDTO preferenceToPreferenceDTO(Preference preference);
	Preference preferenceDTOToPreference(PreferenceDTO preferenceDTO);
	
	PreferenceDTODetails preferenceToPreferenceDTODetails(Preference preference);
	Preference preferenceToPreferencseDTODetails(PreferenceDTODetails preferenceDTODetails);
	
	PreferenceDTO preferenceDTODetailsToPreferenceDTO(PreferenceDTODetails  preferenceDTODetails);
	PreferenceDTODetails preferenceDTOToPreferenceDTODetails(PreferenceDTO prefernceDTO);
	

}

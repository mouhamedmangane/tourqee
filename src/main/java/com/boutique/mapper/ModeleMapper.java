package com.boutique.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.ModeleDTO;
import com.boutique.dto.ModeleDTODetails;
import com.boutique.dto.ModeleDTOFront;
import com.boutique.dto.PreferenceDTO;
import com.boutique.dto.PreferenceDTODetails;
import com.boutique.dto.ProprieteDTO;
import com.boutique.dto.ProprieteDTODetails;
import com.boutique.model.Modele;
import com.boutique.model.Preference;
import com.boutique.model.Propriete;

@Mapper(componentModel = "spring", uses = { PreferenceMapper.class, ProprieteMapper.class, TissuMapper.class,
		CollectionMapper.class, ImageModeleMapper.class ,LigneModelTissuMapper.class})
public interface ModeleMapper {
	ModeleMapper INSTANCE = Mappers.getMapper(ModeleMapper.class);
	
	@Mapping(target="images",ignore=true)
	ModeleDTO modeleToModeleDTO(Modele modele);
	
	@Mapping(target="images",ignore=true)
	Modele modeleDTOToModele(ModeleDTO modele);

	ModeleDTODetails modeleToModeleDTODetails(Modele modele);

	Modele modeleDTODetailsToModele(ModeleDTODetails modeleDTODetails);

	@Mapping(source = "modele.proprietes", target = "preferences")
	ModeleDTOFront modeleToModeleDTOFront(Modele modele);

	@Mapping(source = "modele.preferences", target = "proprietes")
	Modele modeleDTOFrontToModeleDTO(ModeleDTOFront modele);

	@Mapping(source = "modeleDTOFront.preferences", target = "proprietes")
	ModeleDTODetails modeleDTOFrontToModeleDTODetails(ModeleDTOFront modeleDTOFront);

	@Mapping(source = "modeleDTODetails.proprietes", target = "preferences")
	ModeleDTOFront modeleDTODetailsToModeleDTOFront(ModeleDTODetails modeleDTODetails);

	default List<PreferenceDTODetails> proprietesDTODetailsToPreference(List<ProprieteDTODetails> proprietes) {
		List<PreferenceDTODetails> list = new ArrayList<>();
		if (proprietes != null) {
			if (proprietes.size() > 0) {
				if (proprietes.get(0).getPreference() != null) {
					for (ProprieteDTODetails proprieteDTODetails : proprietes) {
						ProprieteDTO proprieteDTO = ProprieteMapper.INSTANCE
								.proprietDTODetailsToProprieteDTO(proprieteDTODetails);
							PreferenceDTODetails preferenceDTODetails=null;
							for (PreferenceDTODetails preferenceDTODetails1 : list) {
								if(proprieteDTODetails.getPreference().getIdPreference()==preferenceDTODetails1.getIdPreference()) {
									preferenceDTODetails = PreferenceMapper.INSTANCE
											.preferenceDTOToPreferenceDTODetails(proprietes.get(0).getPreference());
									break;									}
							}
							if(preferenceDTODetails!=null) {
								preferenceDTODetails.getProprietes().add(proprieteDTO);
							}
							else {
								preferenceDTODetails = new PreferenceDTODetails();
								preferenceDTODetails = PreferenceMapper.INSTANCE
										.preferenceDTOToPreferenceDTODetails(proprieteDTODetails.getPreference());
								preferenceDTODetails.setProprietes(new ArrayList<>());
								
								preferenceDTODetails.getProprietes().add(proprieteDTO);
								list.add(preferenceDTODetails);
							}
						
 
					}
					return list;
				}
			}
		}
		return null;
	}
	
	default List<PreferenceDTODetails> proprietesToPreference(List<Propriete> proprietes) {
		List<PreferenceDTODetails> list = new ArrayList<>();
		if (proprietes != null) {
			if (proprietes.size() > 0) {
				if (proprietes.get(0).getPreference() != null) {
					for (Propriete propriete : proprietes) {
						ProprieteDTO proprieteDTO = ProprieteMapper.INSTANCE
								.prorprieteToProprieteDTO(propriete);
							PreferenceDTODetails preferenceDTODetails=null;
							for (PreferenceDTODetails preferenceDTODetails1 : list) {
								if(propriete.getPreference().getIdPreference()==preferenceDTODetails1.getIdPreference()) {
									preferenceDTODetails = PreferenceMapper.INSTANCE
											.preferenceToPreferenceDTODetails(proprietes.get(0).getPreference());
									break;									}
							}
							if(preferenceDTODetails!=null) {
								preferenceDTODetails.getProprietes().add(proprieteDTO);
							}
							else {
								preferenceDTODetails = new PreferenceDTODetails();
								preferenceDTODetails = PreferenceMapper.INSTANCE
										.preferenceToPreferenceDTODetails(propriete.getPreference());
								preferenceDTODetails.setProprietes(new ArrayList<>());
								
								preferenceDTODetails.getProprietes().add(proprieteDTO);
								list.add(preferenceDTODetails);
							}
						
 
					}
					return list;
				}
			}
		}
		return null;
	}

	default List<ProprieteDTODetails> proprieteDTOToPreference(List<PreferenceDTODetails> preferenceDTODetails) {

		if (preferenceDTODetails != null) {
			if (!preferenceDTODetails.isEmpty()) {
				List<ProprieteDTODetails> list = new ArrayList<>();
				for (PreferenceDTODetails preference : preferenceDTODetails) {
					for (ProprieteDTO propriete : preference.getProprietes()) {
						ProprieteDTODetails proprieteDTODetails = ProprieteMapper.INSTANCE
								.proprieteDTOToProprieteDTO(propriete);
						PreferenceDTO preferenceDTO= PreferenceMapper.INSTANCE.preferenceDTODetailsToPreferenceDTO(preference)     ;
						proprieteDTODetails.setPreference(preferenceDTO);
						list.add(proprieteDTODetails);
					}
				}
				return list;
			}
		}

		return null;
	}
	
	default List<Propriete> proprieteToPreference(List<PreferenceDTODetails> preferenceDTODetails) {

		if (preferenceDTODetails != null) {
			if (!preferenceDTODetails.isEmpty()) {
				List<Propriete> list = new ArrayList<>();
				for (PreferenceDTODetails preference : preferenceDTODetails) {
					for (ProprieteDTO propriete : preference.getProprietes()) {
						Propriete propriete1 = ProprieteMapper.INSTANCE
								.proprieteDTOToPropriete(propriete);
						Preference preference1= PreferenceMapper.INSTANCE.preferenceToPreferencseDTODetails(preference)     ;
						propriete1.setPreference(preference1);
						list.add(propriete1);
					}
				}
				return list;
			}
		}

		return null;
	}

}

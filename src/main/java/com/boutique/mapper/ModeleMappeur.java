package com.boutique.mapper;
import com.boutique.model.Modele;
import com.boutique.model.Preference;
import com.boutique.model.Propriete;
import com.boutique.dto.ProprieteDTODetails;
import com.boutique.dto.ModeleDTODetails;
import com.boutique.dto.ModeleDTOFront;
import com.boutique.dto.PreferenceDTO;
import com.boutique.dto.PreferenceDTODetails;
import com.boutique.dto.ProprieteDTO;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
public class ModeleMappeur {
	private static final ModelMapper modelMapper = new ModelMapper();
	 
	public static List<Preference> converToPreference(List<Propriete> proprietes){
		
		List<Preference> preferences=new ArrayList<>();
		for (Propriete propriete : proprietes) {
			Preference pref=null;
			for (Preference preference2 : preferences) {
				
				if(preference2.getIdPreference()== propriete.getPreference().getIdPreference()) {
					pref=preference2;
					break;
				}
			}
			
			if(pref==null) {
				pref=propriete.getPreference();
				pref.setProprietes(new ArrayList<>());
				preferences.add(pref);
			}
			pref.getProprietes().add(propriete);

			
		}
		return preferences;
	}
	
	public static List<PreferenceDTODetails> converToPreferenceDTO  (List<ProprieteDTODetails> proprietes){
		System.out.println("test---------------------");
		List<PreferenceDTODetails> preferences=new ArrayList<>();
		for (ProprieteDTODetails propriete : proprietes) {
			PreferenceDTODetails pref=null;
			System.out.println("property "+propriete.getIdPropriete());
			for (PreferenceDTODetails preference2 : preferences) {
				System.out.println(preference2.getIdPreference()+" test "+propriete.getPreference().getIdPreference()+" = "+(preference2.getIdPreference() == propriete.getPreference().getIdPreference() ));
				if(preference2.getIdPreference() == propriete.getPreference().getIdPreference()) {
					System.out.println("okkkkkk");pref=preference2;
					break;
				}
			}
			
			if(pref==null) {
				pref  =  modelMapper.map(propriete.getPreference(), PreferenceDTODetails.class);     
				pref.setProprietes(new ArrayList<>());
				preferences.add(pref);
			}
			pref.getProprietes().add(modelMapper.map(propriete, ProprieteDTO.class));
			
		}
		System.out.println("size" + preferences.size());
		return preferences;
	}
	public  static List<ProprieteDTODetails > convertProprietDTO(List<PreferenceDTODetails>  preferences){
		List<ProprieteDTODetails > proprietes=new ArrayList<>();
		for (PreferenceDTODetails pref : preferences) {
			for (ProprieteDTO proprieteDTO : pref.getProprietes()) {
				ProprieteDTODetails propriete= modelMapper.map(proprieteDTO, ProprieteDTODetails.class);
				propriete.setPreference(modelMapper.map(pref,PreferenceDTO.class));
				proprietes.add(propriete);
			}
			
		}
		return proprietes;
	}
	
	public static ModeleDTOFront convertModelDdToFront(ModeleDTODetails modeldd) {
		if(modeldd==null) {
			return null;
		}
		else {
			ModeleDTOFront modelFront=new ModeleDTOFront();
			modelFront.setIdModel(modeldd.getIdModel());
			modelFront.setNom(modeldd.getNom());
			modelFront.setLigneModelTissus(modeldd.getLigneModelTissus());
			modelFront.setCollections(modeldd.getCollections());
			modelFront.setImages(modeldd.getImages());
			modelFront.setPreferences(converToPreferenceDTO(modeldd.getProprietes()));
			modelFront.setDate(modeldd.getDate());
			return modelFront;
		}
	}

}

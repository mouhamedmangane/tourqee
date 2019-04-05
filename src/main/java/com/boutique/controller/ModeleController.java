package com.boutique.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boutique.dao.CollectionRepository;
import com.boutique.dao.ImageModelesRepository;
import com.boutique.dao.LigneModelTissuRepository;
import com.boutique.dao.ModeleRepository;
import com.boutique.dao.ProprieteRepository;
import com.boutique.dao.TypeTissuRepository;
import com.boutique.dto.CollectionDTO;
import com.boutique.dto.ImageModeleDTO;
import com.boutique.dto.LigneModelTissuDTO;
import com.boutique.dto.ModeleDTO;
import com.boutique.dto.ModeleDTODetails;
import com.boutique.dto.ModeleDTOFront;
import com.boutique.dto.PreferenceDTODetails;
import com.boutique.dto.ProprieteDTO;
import com.boutique.dto.ProprieteDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.mapper.ModeleMapper;
import com.boutique.mapper.PreferenceMapper;
import com.boutique.mapper.ProprieteMapper;
import com.boutique.mesImages.PathImage;
import com.boutique.model.Collection;
import com.boutique.model.ImageModele;
import com.boutique.model.LigneModelTissu;
import com.boutique.model.Modele;
import com.boutique.model.Preference;
import com.boutique.model.Propriete;
import com.boutique.model.Tissu;
import com.boutique.model.TypeTissu;
import com.boutique.service.FileStorageService;

@RestController
@CrossOrigin
public class ModeleController {
	private static final ModelMapper modelMapper = new ModelMapper();
	   

	@Autowired
	private ModeleRepository mr;

	@Autowired
	ProprieteRepository proprieteRepository;

	@Autowired
	LigneModelTissuRepository ligneModelTissuRepository;

	@Autowired
	TypeTissuRepository typeTissuRepository;

	@Autowired
	CollectionRepository collectionRepository;

	@Autowired
	private FileStorageService fileStorageService;
	
	@Autowired
	private ImageModelesRepository imr;
	
	@Autowired
	private ModeleMapper modeleMapper;
	
	@Autowired
	private PreferenceMapper preferenceMapper;
	
	@Autowired 
	private ProprieteMapper proprieterMapper;

	@GetMapping(name = "/getAllModele")
	public List<ModeleDTOFront> getAllModel() {
		List<ModeleDTOFront> listModele = new ArrayList<>();
		for (Modele modele : mr.findAll()) {
			ModeleDTOFront l= modeleMapper.modeleToModeleDTOFront(modele);
			listModele.add(l);
		}
		return listModele;
	}

	@GetMapping(path = "/getModeleById/{id}")
	public ModeleDTOFront getModel(@PathVariable("id") Long id) {
		Optional<Modele> oModel=mr.findById(id);
		if(oModel.isPresent()) {
			new NotExistException("le model n existe pas");
		}
		return modeleMapper.modeleToModeleDTOFront(mr.findById(id).get());
	}

	@PostMapping(value = "/saveModeleImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModeleDTOFront saveModeleImage(@RequestPart("modele") ModeleDTOFront modeleDTODetails,@RequestPart("images") List<MultipartFile>  files) throws Exception {
			
		try {
			ModeleDTOFront mmodel= saveModele(modeleDTODetails);
			Modele model= modelMapper.map(mmodel,Modele.class);
			int i=0;
			if (files != null) {
				System.out.println("entrer dansn fi                    les");
				model.setImages(new ArrayList<>());System.out.println("entrer bbbbbbbbbb"+files.size());
				for (MultipartFile file : files) {
					System.out.println("entrer bbbbbbbbbb");
					ImageModele image=new ImageModele();
					image.setModele(model);
					if(i==0) {
						image.setDefaut(true);
						i=1;
					}
					image=imr.save(image);
					System.out.println("image ajoute a labase "+image.nameImage());
					fileStorageService.storeFile(file, PathImage.MODELE.toString(),image.nameImage());
					model.getImages().add(image);
				}
				
			} else {
				System.out.println("image no saved");
			}
			return modelMapper.map(model, ModeleDTOFront.class);
		} catch (Exception e) {
			throw e;
			
		}
	}
	
	@PostMapping("/saveModele")
	public ModeleDTOFront saveModele(@RequestBody ModeleDTOFront modeleDTOFront){
		System.out.println("model :"+modeleDTOFront.getNom());
		
		ModeleDTO modelDTO = modelMapper.map(modeleDTOFront, ModeleDTO.class);
		Modele model = modelMapper.map(modelDTO, Modele.class);
		System.out.println("model :"+modeleDTOFront.getNom());
		model = mr.save(model);
		
		try {
			model.getCollections();
			if (modeleDTOFront.getCollections() != null) {
				model.setCollections(new ArrayList<>());
				for (CollectionDTO collDTO : modeleDTOFront.getCollections()) {
					model.getCollections().add(addCollection(model, collDTO.getIdCollection()));
				}

			}
			// ajout preference
			if (modeleDTOFront.getPreferences() != null) {


			}
			
			// ajoute ListModelTissu
			if (modeleDTOFront.getTissus() != null) {

			}
			
			model = mr.save(model);

		} catch (Exception e) {
			deleteModele(model.getIdModel());
		}

		return modelMapper.map(model, ModeleDTOFront.class);
	}


	@PostMapping("/{idModele}/preferences")
	public List<PreferenceDTODetails> addPreferenceModel(@PathVariable("idModele") long idModele,
			@RequestBody PreferenceDTODetails mDD) {
		System.out.println("\\aaaaaaaaaaaaaaaaaa\n\n");
		Optional<Modele> oModele = mr.findById(idModele);
		if (!oModele.isPresent()) {
			throw new NotExistException("modele " + idModele + " does not exist");
		}
		Modele model=oModele.get();
		List<Modele>  models=new ArrayList<>();
		models.add(model);
		List<Propriete> list=new ArrayList<>();
		for (ProprieteDTO propD : mDD.getProprietes()) {
				Optional<Propriete> Oprop = proprieteRepository.findById(propD.getIdPropriete());
				if (!Oprop.isPresent()) {
					throw new NotExistException("prop does not exist");
				}
				Propriete propriete=Oprop.get();
				propriete.setModels(models);
				list.add(propriete);
		}
		
		model.setProprietes(list);
		model= mr.save(model);
		for (Propriete propriete : model.getProprietes()) {
			System.out.println(propriete.getValeur());
		}
		List<Preference> listPreference = null;
		List<PreferenceDTODetails> listPreferenceDD =new ArrayList<>();
		for (Preference pref : listPreference) {
			listPreferenceDD.add(modelMapper.map(pref,PreferenceDTODetails.class));
		}
		
		return listPreferenceDD;
	}
	
	@PostMapping(value="/{idModele}/addImage")
	public ImageModeleDTO addImage(@PathVariable long idModele,@RequestParam("image") MultipartFile file) {
		System.out.println("\\aaaaaaaaaaaaaaaaaa\n\n");
		Optional<Modele> oModele = mr.findById(idModele);
		if (!oModele.isPresent()) {
			throw new NotExistException("modele " + idModele + " does not exist");
		}
		
		if(file == null  ) {
			throw new NotExistException("file no presente");
		}
		ImageModele imageModele=new ImageModele();
		imageModele.setModele(oModele.get());
		imageModele=imr.save(imageModele);
		System.out.println("image ajoute a labase "+imageModele.nameImage());
		fileStorageService.storeFile(file, PathImage.MODELE.toString(),imageModele.nameImage());
		
		return modelMapper.map(imageModele, ImageModeleDTO.class);
		
	}

	public Propriete addPreference(Modele modele, long idPref) {
		Optional<Propriete> Oppref = proprieteRepository.findById(idPref);
		if (!Oppref.isPresent()) {
			throw new NotExistException("preference does not exist");
		}
//		List<Modele> list=new ArrayList<>();
//		list.add(modele);
		Propriete pref = Oppref.get();
		pref.getModels().add(modele);
		return proprieteRepository.save(pref);
	}

	@PostMapping("/{idModele}/collections")
	public List<CollectionDTO> addCollectionModele(@PathVariable long idModele, @RequestBody ModeleDTODetails mDD) {
		Optional<Modele> oModele = mr.findById(idModele);
		if (!oModele.isPresent()) {
			throw new NotExistException("modele " + idModele + " does not exist");
		}
		Modele model=oModele.get();
		List<Modele>  models=new ArrayList<>();
		models.add(model);
		List<Collection> list=new ArrayList<>();
		for (CollectionDTO colD : mDD.getCollections()) {
			Optional<Collection> Ocol = collectionRepository.findById(colD.getIdCollection());
			if (!Ocol.isPresent()) {
				throw new NotExistException("collection does not exist");
			}
			Collection collection=Ocol.get();
			collection.setModels(models);
			list.add(collection);
		}

		model.setCollections(list);
		model=mr.save(model);
		for (CollectionDTO collection : modelMapper.map(model , ModeleDTODetails.class).getCollections()) {
			System.out.println(collection.getNom());
		}
	
		return modelMapper.map(model , ModeleDTODetails.class).getCollections();
	}

	public Collection addCollection(Modele modele, long idCollection) {
		Optional<Collection> Ocol = collectionRepository.findById(idCollection);
		if (!Ocol.isPresent()) {
			throw new NotExistException("collection does not exist");
		}
//		List<Modele> list=new ArrayList<>();
//		list.add(modele);
		Collection pref = Ocol.get();
		pref.getModels().add(modele);
		return pref = collectionRepository.save(pref);
	}

	@PostMapping("/{idModele}/typeTissus")
	public List<LigneModelTissuDTO> addLigneModeleTissuModele(@PathVariable long idModele, @RequestBody ModeleDTODetails mDD) {
		
		for (LigneModelTissuDTO pp : mDD.getLigneModelTissus()) {
			System.out.println("typeTissu nom: " +pp.getTypeTissu().getNom()); 
			System.out.println("typeTissu id: " +pp.getTypeTissu().getIdTypeTissu()); 
			System.out.println("ligne "+pp.getIdLigneModelTissu());
		}
		Optional<Modele> oModele = mr.findById(idModele);
		if (!oModele.isPresent()) {
			throw new NotExistException("modele " + idModele + " does not exist");
		}
		
		Modele model=oModele.get();
		List<LigneModelTissu> list = new ArrayList<>();
		
		
		for (LigneModelTissuDTO colD : mDD.getLigneModelTissus()) {
			LigneModelTissu ligne= new LigneModelTissu();
			ligne.setModele(model);
			ModeleDTO modeldto=new ModeleDTO();
			modeldto.setIdModel(model.getIdModel());
			colD.setModele(modeldto);
	
			
			
			Optional<TypeTissu> oTtr = typeTissuRepository.findById(colD.getTypeTissu().getIdTypeTissu());
			if (!oTtr.isPresent()) {
				throw new NotExistException("typeTissu  does not exist "+colD.getTypeTissu().getIdTypeTissu());
			}
			ligne.setTypeTissu(oTtr.get());
			LigneModelTissu Ocol = ligneModelTissuRepository.findByModelTissu(colD.getModele().getIdModel(),colD.getIdLigneModelTissu());
			if (Ocol != null) {
				ligne.setIdLigneModelTissu(Ocol.getIdLigneModelTissu());
			}
			System.out.println(ligne.getIdLigneModelTissu()+" "+ligne.getTypeTissu().getNom());
			ligne=ligneModelTissuRepository.save(ligne);
			list.add(ligne);
		}

		model.setLigneModelTissus(list);
	
		return modelMapper.map(model , ModeleDTODetails.class).getLigneModelTissus();
	}

	public LigneModelTissu addLigneModeleTissu(Modele modele, LigneModelTissu modelTissu) {

		Optional<TypeTissu> oTtr = typeTissuRepository.findById(modelTissu.getTypeTissu().getIdTypeTissu());
		if (!oTtr.isPresent()) {
			throw new NotExistException("typeTissu does not exist");
		}
		modelTissu.setModele(modele);
		modelTissu.setTypeTissu(oTtr.get());
		LigneModelTissu ligne = ligneModelTissuRepository.findByModelTissu(modele.getIdModel(),
				oTtr.get().getIdTypeTissu());
		if (ligne != null) {
			modelTissu.setIdLigneModelTissu(ligne.getIdLigneModelTissu());
		}
		return ligneModelTissuRepository.save(modelTissu);
	}

	@DeleteMapping("/deleteModele/{id}")
	public boolean deleteModele(@PathVariable Long id) {
		Optional<Modele> oModele=mr.findById(id);
		if (!oModele.isPresent())
			throw new NotExistException("ce propriete n existe pas");
		Modele modele = oModele.get();
		for (ImageModele image : modele.getImages()) {
			imr.deleteById(image.getIdImage());
			fileStorageService.deleteFile(PathImage.MODELE, image.nameImage());
		}
		modele.setIdModel(id);

		mr.deleteById(id);
		return true;
	}
	@DeleteMapping("/deleteImageModele/{id}")
	public boolean deleteImageModele(@PathVariable Long id) {
		Optional<ImageModele> oImageModele= imr.findById(id);
		if (!oImageModele.isPresent())
			throw new NotExistException("ce Image n existe pas");
		ImageModele image = oImageModele.get();
		
			imr.deleteById(image.getIdImage());
			fileStorageService.deleteFile(PathImage.MODELE, image.nameImage());
		

		return true;
	}
}

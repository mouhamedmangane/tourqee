package com.boutique.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.ClientRepository;
import com.boutique.dao.CommandeRepository;
import com.boutique.dao.LigneCommandeRepository;
import com.boutique.dao.LigneMesureRepository;
import com.boutique.dao.LigneProprieteRepository;
import com.boutique.dao.MesureRepository;
import com.boutique.dao.ModeleRepository;
import com.boutique.dao.ProduitRepository;
import com.boutique.dao.ProprieteRepository;
import com.boutique.dao.TissuRepository;
import com.boutique.dto.CommandeDTO;
import com.boutique.dto.CommandeDTODetails;
import com.boutique.dto.CommandeDTOSave;
import com.boutique.dto.CommandeDTOSimple;
import com.boutique.dto.LigneCommandeDTODetais;

import com.boutique.dto.LigneProprieteDTODetails;

import com.boutique.dto.ProduitDTODetails;
import com.boutique.dto.ProprieteDTO;
import com.boutique.dto.TissuDTODetails;
import com.boutique.exception.EchecOperation;
import com.boutique.exception.NotExistException;
import com.boutique.model.Client;
import com.boutique.model.Commande;
import com.boutique.model.LigneCommande;
import com.boutique.model.LignePropriete;
import com.boutique.model.LigneProprietePK;
import com.boutique.model.Mesure;
import com.boutique.model.Modele;
import com.boutique.model.Produit;
import com.boutique.model.Propriete;
import com.boutique.model.Tissu;


@RestController
@CrossOrigin
public class CommandeController {
	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private CommandeRepository cr;

	@Autowired
	private LigneCommandeRepository ligneCr;

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private LigneProprieteRepository ligneProprieteRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ModeleRepository modeleRepository;

	@Autowired
	private ProprieteRepository proprieteRepository;

	@Autowired
	private TissuRepository tissuRepository;

	@Autowired
	private MesureRepository mesureRepository;

	@Autowired
	private LigneMesureRepository ligneMesureRepository;

	@GetMapping(path = "/getListCommande")
	public List<Commande> getListCommande() {
		return cr.findAll();
	}

	@GetMapping(path = "/getEtatCommande/{id}")
	public Optional<Commande> getEtatCommande(@PathVariable Long id) {
		return cr.findById(id);
	}
	
	@GetMapping(path = "/deleteCommande/{id}")
	public boolean deleteCommande(@PathVariable Long id) {
		 cr.deleteById(id);
		return true;
	}
	
	

	@PostMapping(path = "/saveLigneCommande")
	public LigneCommande saveLigneCommande(@RequestBody LigneCommandeDTODetais ligneCommandeDTO) {
		LigneCommande ligneCommande = modelMapper.map(ligneCommandeDTO, LigneCommande.class);
		Produit p=saveProduit(ligneCommandeDTO.getProduit());
		ligneCommande.setProduit(p);
		return ligneCr.save(ligneCommande);
	}
	
	public Produit saveProduit(ProduitDTODetails produitDT0)throws NotExistException {
		Optional<Modele> omodel = modeleRepository.findById(produitDT0.getModele().getIdModel());
		if (!omodel.isPresent()) {
			throw new NotExistException("ce modele n'existe pas");
		}
		Produit produit = modelMapper.map(produitDT0, Produit.class);
		produit.setModele(omodel.get());
		
		if(produitDT0.getMesure()!=null) {
			Optional<Mesure> oMesure=mesureRepository.findById(produitDT0.getMesure().getIdMesure());
			if(!oMesure.isPresent()) {
				throw new NotExistException("ce mesure n'existe pas");
			}
			produit.setMesure(oMesure.get());
			
		}
		
		produitRepository.save(produit);
		
		if(produitDT0.getTissus()!=null) {
			produit=saveProduitTissu(produit, produitDT0.getTissus());
		}
		if(produitDT0.getLigneProprietes()!=null) {
			produit.setLigneProprietes(new ArrayList<>());
			for (LigneProprieteDTODetails ligne : produitDT0.getLigneProprietes()) {
				ProprieteDTO proprieteDTO=modelMapper.map(ligne, ProprieteDTO.class);
				produit.getLigneProprietes().add(saveProduitPropriete(produit.getIdProduit(), proprieteDTO));
			}
		}
		
		
		return produit;
	}
	

	
	public Produit saveProduitTissu(Produit produit,List<TissuDTODetails> tissus)throws NotExistException {

			List<Tissu> listTissu=new ArrayList<>();
			List<Produit> listProduit = new ArrayList<>();
			listProduit.add(produit);
			for (TissuDTODetails tisssuDTO : tissus) {
				Optional<Tissu> oTissu = tissuRepository.findById(tisssuDTO.getIdTissu());
				if(!oTissu.isPresent())
					throw new NotExistException("ce tissu n'existe pas");
				Tissu tissu=oTissu.get();
				tissu.setProduits(listProduit);
				tissu = tissuRepository.save(tissu);
				listTissu.add(tissu);

			}
			produit.setTissus(listTissu);
			return produit;
	}
	
	public LignePropriete saveProduitPropriete(long idProduit,ProprieteDTO proprieteDTO)throws NotExistException {
		Optional<Propriete> oPropriete = proprieteRepository.findById(proprieteDTO.getIdPropriete());
		if(!oPropriete.isPresent())
			throw new NotExistException("ce propriete n'existe pas");
		Propriete propriete = modelMapper.map(oPropriete.get(), Propriete.class);
		LignePropriete lignePropriete = new LignePropriete();
		LigneProprietePK idLignePropriete = new LigneProprietePK();
		idLignePropriete.setIdProduit(idProduit);
		idLignePropriete.setIdPropriete(propriete.getIdPropriete());
		lignePropriete.setLignePropiretePK(idLignePropriete);
		lignePropriete.setPropriete(propriete);
		return ligneProprieteRepository.save(lignePropriete);
	}

	@PostMapping(path = "/saveCommande")
	public CommandeDTODetails saveCommande(@RequestBody CommandeDTOSave commandeDTODetails) {

		Commande commande = modelMapper.map(commandeDTODetails, Commande.class);
		commande.setDateDebut(new Date());
		if(commande.getDateDebut().after(commande.getDateFin())) {
			throw new RuntimeException("La date d'enregistement de la commande ne peut pas etre superieur a la date de delivrance :"+
										commande.getDateDebut()+"  >   "+commande.getDateFin());
		}
		Optional<Client> oClient=clientRepository.findById(commandeDTODetails.getClient().getIdClient());
		if(!oClient.isPresent()) {
			throw new NotExistException("Ce client n'existe pas");
		}
		commande.setClient(oClient.get());
		commande = cr.save(commande);
		try {
			commande.setLigneCommandes(new ArrayList<>());
			for (LigneCommandeDTODetais ligne : commandeDTODetails.getLigneCommandes()) {
					CommandeDTOSimple commandeDTOSimple = modelMapper.map(commande,CommandeDTOSimple.class);
					ligne.setCommande(commandeDTOSimple);
					commande.getLigneCommandes().add(saveLigneCommande(ligne));
				
			}
		} catch (Exception e) {
			deleteCommande(commande.getIdCommande());
			throw e;
			//throw new EchecOperation("Ajout Client");
		}
		

		return modelMapper.map(commande, CommandeDTODetails.class);
	}
	
	@GetMapping(path = "/getCommandeById/{id}")
	public CommandeDTODetails getCommandeById(@PathVariable Long id) {
		 Optional<Commande> oCommande  =  cr.findById(id);
		 if  (!oCommande.isPresent()) {
			 throw new NotExistException("cette commande n'existe pas");
		 }
		return modelMapper.map(oCommande.get(), CommandeDTODetails.class);
	}

	@PutMapping(path = "/updateEtatCommande")
	public CommandeDTODetails updateEtatCommande(@RequestBody CommandeDTO commandeDTO) {
		Commande commande = modelMapper.map(commandeDTO, Commande.class);
		return modelMapper.map(cr.save(commande), CommandeDTODetails.class);
	}

	@GetMapping("getAllCommande")
	public List<CommandeDTODetails> getAllCommande() {
		List<CommandeDTODetails> listCommande = new ArrayList<>();
		for (Commande commande : cr.findAll()) {
			CommandeDTODetails l = modelMapper.map(commande, CommandeDTODetails.class);
			listCommande.add(l);
		}
		return listCommande;
	}
}

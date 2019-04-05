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
import com.boutique.dto.CommandeDTOClient;
import com.boutique.dto.CommandeDTODetails;
import com.boutique.dto.CommandeDTOSave;
import com.boutique.dto.CommandeDTOSimple;
import com.boutique.dto.LigneCommandeDTOClient;
import com.boutique.dto.LigneCommandeDTODetais;
import com.boutique.dto.LigneMesureDTO;
import com.boutique.dto.LigneProprieteDTODetails;

import com.boutique.dto.ProduitDTODetails;
import com.boutique.dto.ProprieteDTO;
import com.boutique.dto.TissuDTODetails;
import com.boutique.exception.EchecOperation;
import com.boutique.exception.NotExistException;
import com.boutique.mapper.CommandeMapper;
import com.boutique.model.Client;
import com.boutique.model.Commande;
import com.boutique.model.EtatCommande;
import com.boutique.model.LigneCommande;
import com.boutique.model.LigneMesure;
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
	
	@Autowired
	private CommandeMapper commandeMapper;

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
	public LigneCommandeDTODetais saveLigneCommandeDD(@RequestBody LigneCommandeDTODetais ligneCommandeDTO) {
		
		LigneCommande ligneCommande = modelMapper.map(ligneCommandeDTO, LigneCommande.class);
		for (LigneMesure ligneMesure : ligneCommande.getProduit().getMesure().getLigneMesures()) {
			System.out.println("ligne mesure   "+ligneMesure.getValeur());
			System.out.println("ligne msure   "+ligneMesure.getProprieteMesure());
		}
		Produit p=saveProduit(ligneCommandeDTO.getProduit());
		ligneCommande.setProduit(p);
		return modelMapper.map(ligneCr.save(ligneCommande),LigneCommandeDTODetais.class);
	}

	public LigneCommande saveLigneCommande(@RequestBody LigneCommandeDTODetais ligneCommandeDTO) {
		LigneCommande ligneCommande = modelMapper.map(ligneCommandeDTO, LigneCommande.class);
		Produit p=saveProduit(ligneCommandeDTO.getProduit());
		ligneCommande.setProduit(p);
		return ligneCr.save(ligneCommande);
	}
	
	@GetMapping(path= "/deleteLigneCommandeById/{id}")
	public boolean deleteLigneCommandeById(@PathVariable long id) {
		Optional<LigneCommande> oLigne = ligneCr.findById(id);
		if(!oLigne.isPresent()) {
			throw new NotExistException("ligneCommande not exist ");
		}
		ligneCr.deleteById(id);
		return true;
	}
	
	public Produit saveProduit(ProduitDTODetails produitDT0)throws NotExistException {
		Optional<Modele> omodel = modeleRepository.findById(produitDT0.getModele().getIdModel());
		if (!omodel.isPresent()) {
			throw new NotExistException("ce modele n'existe pas");
		}
		Produit produit = modelMapper.map(produitDT0, Produit.class);
		produit.setModele(omodel.get());
		
		if(produitDT0.getMesure()!=null) {
			Mesure mesure = mesureRepository.save(produit.getMesure());
			ArrayList<LigneMesure> list = new ArrayList<>();
			for (LigneMesure ligneMesure : produit.getMesure().getLigneMesures()) {
				System.out.println("ligne mesure   "+ligneMesure.getValeur());
				System.out.println("ligne msure   "+ligneMesure.getProprieteMesure());
				ligneMesure.setMesure(mesure);
				list.add(ligneMesureRepository.save(ligneMesure));
			}
			mesure.setLigneMesures(list);
			produit.setMesure(mesure);
			
		}
		
		produitRepository.save(produit);
		
		if(produitDT0.getTissus()!=null) {
			produit=saveProduitTissu(produit, produitDT0.getTissus());
		}
		if(produitDT0.getProprietes()!=null) {
			produit.setLigneProprietes(new ArrayList<>());
			for (ProprieteDTO ligne : produitDT0.getProprietes()) {
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

		Commande commande = commandeMapper.commandeDTOSaveToCommande(commandeDTODetails);
		commande.setDateDebut(new Date());
		if(commande.getEtatCommande()==null) {
			commande.setEtatCommande(EtatCommande.EN_COURS);
		}
		if(commande.getDateFin()== null) {
			commande.setDateFin(new Date());
			commande.setEtatCommande(EtatCommande.EN_ATTENTE);
		}
			
		
		if(commande.getDateDebut().after(commande.getDateFin())) {
			throw new RuntimeException("La date d'enregistement de la commande ne peut pas etre superieur a la date de delivrance :"+
										commande.getDateDebut()+"  >   "+commande.getDateFin());
		}
		Optional<Client> oClient=clientRepository.findById(commandeDTODetails.getClient().getIdPersonne());
		if(!oClient.isPresent()) {
			throw new NotExistException("Ce client n'existe pas");
		}
		commande.setClient(oClient.get());
		commande = cr.save(commande);
		try {
			commande.setLigneCommandes(new ArrayList<>());
			for (LigneCommandeDTODetais ligne : commandeDTODetails.getLigneCommandes()) {
					CommandeDTOSimple commandeDTOSimple = modelMapper.map(commande,CommandeDTOSimple.class);
					if(ligne.getProduit().getMesure()!=null) {
						ligne.getProduit().getMesure().setClient(commandeDTODetails.getClient());
					}
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
	
	@PostMapping(path = "/saveCommandeClient")
	public boolean saveCommandeClient(@RequestBody CommandeDTOClient commandeDTOClient) {
		System.out.println("gffffffgfgf"+commandeDTOClient);
		System.out.println(commandeDTOClient.getClient().getNom());
		if(commandeDTOClient.getLigneCommandes()!=null) {
			for (LigneCommandeDTOClient ligne : commandeDTOClient.getLigneCommandes()) {
				System.out.println(ligne.getModel().getNom());
				System.out.println(ligne.getQuantite());
			}
		}
		Commande commande = commandeMapper.commandeDTOClientToCommande(commandeDTOClient);
		System.out.println("ccccccccccccccccccccc");
		if(commande.getLigneCommandes()!=null) {
			System.out.println("ol");
			for (LigneCommande ligne : commande.getLigneCommandes()) {
				System.out.println("kkkkkkkk");
				System.out.println(ligne.getProduit().getModele().getNom());
				System.out.println(ligne.getQuantite());
			}
		}
		CommandeDTOSave commandeDTOSave=commandeMapper.commandeToCommandeDtoSave(commande);
		System.out.println("ddddddddddddddddddddddddddddddddddddddddd");
		if(commandeDTOSave.getLigneCommandes()!=null) {
			for (LigneCommandeDTODetais ligne : commandeDTOSave.getLigneCommandes()) {
				System.out.println(ligne.getProduit().getModele().getNom());
				System.out.println(ligne.getQuantite());
			}
		}
			saveCommande(commandeDTOSave);
			return true;
		
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
	
	@GetMapping("getAllCommandeByEtat/{etat}")
	public List<CommandeDTODetails> getAllCommandeByEtat(@PathVariable("etat")EtatCommande etatCommande) {
		List<CommandeDTODetails> listCommande = new ArrayList<>();
		for (Commande commande : cr.findByEtat(etatCommande)) {
			CommandeDTODetails l = modelMapper.map(commande, CommandeDTODetails.class);
			listCommande.add(l);
		}
		return listCommande;
	}
	
	@GetMapping("getAllCommandeByArchiver/{archiver}")
	public List<CommandeDTODetails> getAllCommandeByEtat(@PathVariable("archiver")boolean archiver) {
		List<CommandeDTODetails> listCommande = new ArrayList<>();
		for (Commande commande : cr.findByArchiver(archiver)) {
			CommandeDTODetails l = modelMapper.map(commande, CommandeDTODetails.class);
			listCommande.add(l);
		}
		return listCommande;
	}
}

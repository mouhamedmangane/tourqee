package com.boutique.controller;

import java.util.ArrayList;
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
import com.boutique.dto.LigneCommandeDTODetais;
import com.boutique.dto.LigneMesureDTO;
import com.boutique.dto.LigneProprieteDTODetails;
import com.boutique.dto.TissuDTODetails;
import com.boutique.model.Commande;
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

	@GetMapping(path = "/getListCommande")
	public List<Commande> getListCommande() {
		return cr.findAll();
	}

	@GetMapping(path = "/getEtatCommande/{id}")
	public Optional<Commande> getEtatCommande(@PathVariable Long id) {
		return cr.findById(id);
	}

	@PostMapping(path = "/saveLigneCommande")
	public LigneCommande saveLigneFournisseur(@RequestBody LigneCommande ligneCommande) {
		return ligneCr.save(ligneCommande);
	}

	@PostMapping(path = "/saveCommande")
	public CommandeDTODetails saveModele(@RequestBody CommandeDTOSave commandeDTODetails) {

		Commande commande = modelMapper.map(commandeDTODetails, Commande.class);
		commande = cr.save(commande);
		commande.setClient(clientRepository.findById(commandeDTODetails.getClient().getIdClient()).get());

		int i = 0;
		for (LigneCommandeDTODetais ligne : commandeDTODetails.getLigneCommandes()) {
			LigneCommande ligneCommande = modelMapper.map(ligne, LigneCommande.class);
			Produit produit = modelMapper.map(ligne.getProduit(), Produit.class);
			// model
			Optional<Modele> omodel = modeleRepository.findById(ligne.getProduit().getModele().getIdModel());
			if (omodel.isPresent()) {
				Modele model = omodel.get();
				produit.setModele(model);
				// Mesure
				if (ligne.getProduit().getMesure() != null) {
					Mesure mesure = modelMapper.map(ligne.getProduit().getMesure(), Mesure.class);
					mesure.setClient(commande.getClient());
					mesure = mesureRepository.save(mesure);
					mesure.setLigneMesures(new ArrayList<>());
					for (LigneMesureDTO ligneMesureDTO : ligne.getProduit().getMesure().getLigneMesures()) {
						LigneMesure ligneMesure = ligneMesureRepository.findByMesurePropriete(mesure.getIdMesure(),
								ligneMesureDTO.getProprieteMesure());
						if (ligneMesure != null) {
							ligneMesureDTO.setIdLigneMesure(ligneMesure.getIdLigneMesure());
						}
						ligneMesure = modelMapper.map(ligneMesureDTO, LigneMesure.class);
						ligneMesure.setMesure(mesure);
						ligneMesure = ligneMesureRepository.save(ligneMesure);
						mesure.getLigneMesures().add(ligneMesure);
					}
					produit.setMesure(mesure);
				}

				produit.setTissus(null);
				produit = produitRepository.save(produit);
				// propriete
				if (ligne.getProduit().getLigneProprietes() != null) {
					List<LignePropriete> ligneProprietes = new ArrayList<>();
					for (LigneProprieteDTODetails lignePDD : ligne.getProduit().getLigneProprietes()) {
						LignePropriete lignePropriete = new LignePropriete();
						Propriete propriete = modelMapper.map(lignePDD.getPropriete(), Propriete.class);
						propriete = proprieteRepository.findById(propriete.getIdPropriete()).get();
						lignePropriete.setPropriete(propriete);
						LigneProprietePK idLignePropriete = new LigneProprietePK();
						idLignePropriete.setIdProduit(produit.getIdProduit());
						idLignePropriete.setIdPropriete(propriete.getIdPropriete());
						lignePropriete.setLignePropiretePK(idLignePropriete);
						ligneProprietes.add(ligneProprieteRepository.save(lignePropriete));
					}
					produit.setLigneProprietes(ligneProprietes);
				}
				// tissu
				if (ligne.getProduit().getTissus() != null) {
					produit.setTissus(new ArrayList<>());
					List<Produit> listProduit = new ArrayList<>();
					listProduit.add(produit);
					for (TissuDTODetails tisssuDTODetails : ligne.getProduit().getTissus()) {
						Tissu tissu = tissuRepository.findById(tisssuDTODetails.getIdTissu()).get();
						tissu.setProduits(listProduit);
						tissu = tissuRepository.save(tissu);
						produit.getTissus().add(tissu);

					}

				}

				ligneCommande.setProduit(produit);
				ligneCommande.setCommande(commande);
				commande.getLigneCommandes().set(i, ligneCr.save(ligneCommande));
				i++;
			}
		}

		return modelMapper.map(commande, CommandeDTODetails.class);
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

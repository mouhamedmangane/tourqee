package com.boutique.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.CategoryRepository;
import com.boutique.dao.ClientRepository;
import com.boutique.dao.CollectionRepository;
import com.boutique.dao.CommandeRepository;
import com.boutique.dao.ModeleRepository;
import com.boutique.dto.DashboardDTO;
import com.boutique.model.EtatCommande;

@RestController
@CrossOrigin
public class StatistiqueController {
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private CollectionRepository collectionRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModeleRepository modeleRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/getDashboard")
	public DashboardDTO getDashbord() {
		DashboardDTO dash=new DashboardDTO();
		dash.setNbrCommandeEnAttente(this.commandeRepository.countCommandeByEtat(EtatCommande.EN_ATTENTE));
		dash.setNbrCommandeEnCours(this.commandeRepository.countCommandeByEtat(EtatCommande.EN_COURS));
		dash.setNbrCommandeTermine(this.commandeRepository.countCommandeByEtat(EtatCommande.TERMINÉ));
		dash.setNbrCommandeLivre(this.commandeRepository.countCommandeByEtat(EtatCommande.LIVRÉ));
		
		dash.setNbrCategorie(this.categoryRepository.count());
		dash.setNbrCollection(this.collectionRepository.count());
		dash.setNbrModele(this.modeleRepository.countModele());
		dash.setNbrModeleSansCollection(this.modeleRepository.countModeleSansCollection());
		
		dash.setNbrClient(this.clientRepository.count());
		
		return dash;
	}
	
	@GetMapping(path="/evalCommandeInYear/{annee}")
	public long[]  getCountClient(@PathVariable int annee) {
		long  tab[]=new long[12];
		Object[][] list = this.commandeRepository.statistique(annee);
		for (Object[] objects : list) {
			String mois=objects[0].toString();
			String nbr=objects[1].toString();
			int index= Integer.valueOf(mois.trim()).intValue();
			tab[index]=Long.valueOf(nbr.trim()).longValue();
		}
		return tab;
	}
	
	

}

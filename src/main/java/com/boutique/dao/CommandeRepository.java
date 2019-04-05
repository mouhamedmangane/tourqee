package com.boutique.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.boutique.model.Commande;
import com.boutique.model.EtatCommande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	
	@Query("select c from Commande c where c.etatCommande like :etatCommande")
	public List<Commande> findByEtat(@Param("etatCommande") EtatCommande etatCommande);
	
	@Query("select c from Commande c where c.archiver = :archiver")
	public List<Commande> findByArchiver(@Param("archiver")boolean archiver);
	
	@Transactional
	@Query("update Commande c set c.archiver=:archiver")
	public void archiver(@Param("archiver") boolean  archiver);
	
}

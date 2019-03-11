package com.boutique.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boutique.model.Modele;

public interface ModeleRepository extends JpaRepository<Modele, Long> {

	
	@Query("select n from Modele n where n not in (select m from Collection c join c.models m) ")
	public List<Modele> getAllModeleSansCollection();
}

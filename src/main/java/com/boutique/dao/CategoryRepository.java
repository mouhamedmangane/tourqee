package com.boutique.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.Categorie;

public interface CategoryRepository extends JpaRepository<Categorie, Long> {

	@Query("select c from Categorie c where nom like :nom")
	public Categorie findByNom(@Param("nom") String nom);
	
	@Query("select count(c) from Categorie c ")
	public int countCategorie();
}

package com.boutique.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.Collection;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

	
	@Query("select co from Collection co where co.categorie.idCategorie=:idCategorie")
	public List<Collection> findByCategorie(@Param("idCategorie") long idCategorie);
	
	@Query("select c from Collection  c where c.nom like :nom and c.categorie.idCategorie=:idCategorie")
	public Collection findNomIdCategorie(@Param("nom") String nom,@Param("idCategorie")long idCategorie);


}

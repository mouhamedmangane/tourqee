package com.boutique.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

	@Transactional
	@Query(value="insert into produit_propriete  values(:idProduit,:idPropriete)" , nativeQuery = true)
	public void insertPropieteOfProduit(@Param("idProduit") long idProduit,@Param("idPropriete") long idPropriete);
}

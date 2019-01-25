package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.LigneModelTissu;

public interface LigneModelTissuRepository extends JpaRepository<LigneModelTissu, Long> {
	@Query("select l from LigneModelTissu l where l.modele.idModel=:idModel and l.typeTissu.idTypeTissu = :idTypeTissu")
	public LigneModelTissu findByModelTissu(@Param("idModel")long idModel,@Param("idTypeTissu") long idTypeTissu);
}

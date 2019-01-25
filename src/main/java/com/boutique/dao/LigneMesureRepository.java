package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.LigneMesure;
import com.boutique.model.ProprieteMesure;

public interface LigneMesureRepository extends JpaRepository<LigneMesure, Long> {
	@Query("select l from LigneMesure l where l.mesure.idMesure=:idMesure and l.proprieteMesure like :prop")
	public LigneMesure findByMesurePropriete(@Param("idMesure")long idMesure,@Param("prop") ProprieteMesure prop);
}

package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.LignePropriete;
import com.boutique.model.LigneProprietePK;

public interface LigneProprieteRepository extends JpaRepository<LignePropriete, LigneProprietePK>{

}

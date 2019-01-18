package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

}

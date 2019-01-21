package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}

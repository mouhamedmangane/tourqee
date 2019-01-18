package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}

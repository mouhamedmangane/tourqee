package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Adresse;

public interface LigneCommandeRepository extends JpaRepository<Adresse, Long> {

}

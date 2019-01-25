package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

}

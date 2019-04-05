package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Personne;

public interface PersonneRepository  extends JpaRepository<Personne, Long> {

}

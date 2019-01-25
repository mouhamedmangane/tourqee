package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Mesure;

public interface MesureRepository extends JpaRepository<Mesure, Long> {

}

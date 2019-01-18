package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Propriete;


public interface ProprieteRepository extends JpaRepository<Propriete, Long> {

}

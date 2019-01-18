package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Tissu;

public interface TissuRepository extends JpaRepository<Tissu, Long> {

}

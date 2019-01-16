package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Categorie;

public interface CategoryRepository extends JpaRepository<Categorie, Long> {

}

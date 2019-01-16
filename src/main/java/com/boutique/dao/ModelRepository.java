package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

}

package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

}

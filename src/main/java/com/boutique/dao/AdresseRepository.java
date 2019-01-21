package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

		public void voir();
}

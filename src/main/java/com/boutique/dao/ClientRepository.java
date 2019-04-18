package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select count(c) from Client c ")
	public int countClient();
}

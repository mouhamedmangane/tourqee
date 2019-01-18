package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

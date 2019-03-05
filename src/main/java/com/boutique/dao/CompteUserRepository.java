package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.CompteUser;

public interface CompteUserRepository  extends JpaRepository<CompteUser, Long> {

}

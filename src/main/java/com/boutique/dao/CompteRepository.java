package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{
	
	
	@Query("select c from Compte c where c.login = :login and c.mdp = :mdp")
	public Compte connexion(@Param("login")String  login,@Param("mdp")String mdp); 
}

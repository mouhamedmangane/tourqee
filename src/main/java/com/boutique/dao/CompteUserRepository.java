package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.Compte;
import com.boutique.model.CompteUser;

public interface CompteUserRepository  extends JpaRepository<CompteUser, Long> {
	@Query("select c from CompteUser c where c.login = :login and c.mdp = :mdp")
	public CompteUser connexion(@Param("login")String  login,@Param("mdp")String mdp);
}

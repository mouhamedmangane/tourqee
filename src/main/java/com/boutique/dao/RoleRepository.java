package com.boutique.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boutique.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query("select r from Role r where r.nom=:nom")
	public Optional<Role> getRoleByNom(@Param("nom") String nom);
}

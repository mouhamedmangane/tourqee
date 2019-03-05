package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

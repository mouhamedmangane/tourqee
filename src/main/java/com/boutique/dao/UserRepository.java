package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

package com.boutique.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Preference;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
	

}

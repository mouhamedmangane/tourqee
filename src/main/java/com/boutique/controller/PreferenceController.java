package com.boutique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.PreferenceRepository;
import com.boutique.model.Preference;

@RestController
public class PreferenceController {
	
	@Autowired
	private PreferenceRepository pr;
	
	//--------- Create Preference ---------------
	@RequestMapping(path="/savePreference", method=RequestMethod.POST)
	public Preference savePreference(@RequestBody Preference preference) {
		return pr.save(preference);
	}

}

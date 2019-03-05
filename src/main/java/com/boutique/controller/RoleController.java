package com.boutique.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.dao.RoleRepository;
import com.boutique.dto.RoleDTO;
import com.boutique.dto.RoleDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.model.Role;

import javassist.expr.NewArray;

@RestController
@CrossOrigin
public class RoleController {
	
	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private RoleRepository roleRepository;
	
	
	@PostMapping("/saveRole")
	public RoleDTO saveRole(@RequestBody RoleDTO roleDTO) {
		Role role = modelMapper.map(roleDTO, Role.class);
		roleDTO = modelMapper.map(roleRepository.save(role), RoleDTO.class);
		return roleDTO;
	}
	
	@GetMapping("/getRoleById{id}")
	public RoleDTO getRoleById(@PathVariable long id) {
		Optional<Role> oRole = roleRepository.findById(id);
		if(!oRole.isPresent()) {
			throw new NotExistException("aucun role avec id : "+id);
		}
		return modelMapper.map(oRole.get(), RoleDTO.class);
	}
	
	@GetMapping("/getRoleDetailsById{id}")
	public RoleDTODetails getRoleDetailsById(@PathVariable long id) {
		Optional<Role> oRole = roleRepository.findById(id);
		if(!oRole.isPresent()) {
			throw new NotExistException("aucun role avec id : "+id);
		}
		return modelMapper.map(oRole.get(), RoleDTODetails.class);
	}
	
	@GetMapping("/getAllRole")
	public List<RoleDTO> getAllRole(){
		List<Role> roles= roleRepository.findAll();
		List<RoleDTO> list = new ArrayList<RoleDTO>(roles.size());
		for (Role role : roles) {
			RoleDTO roleDTO = modelMapper.map(role,RoleDTO.class);
			list.add(roleDTO);
		}
		return list;
	}
	
	@GetMapping("/getAllRoleDetails")
	public List<RoleDTODetails> getAllRoleDetails(){
		List<Role> roles= roleRepository.findAll();
		List<RoleDTODetails> list = new ArrayList<RoleDTODetails>(roles.size());
		for (Role role : roles) {
			RoleDTODetails roleDTO = modelMapper.map(role,RoleDTODetails.class);
			list.add(roleDTO);
		}
		return list;
	}
	
	@DeleteMapping("/deleteRoleById/{id}")
	public  boolean deleteRoleById (@PathVariable long id) {
		Optional<Role> oRole = roleRepository.findById(id);
		if(!oRole.isPresent()) {
			throw new NotExistException("aucun role avec id : "+id);
		}
		roleRepository.deleteById(id);
		return true;
	}

}

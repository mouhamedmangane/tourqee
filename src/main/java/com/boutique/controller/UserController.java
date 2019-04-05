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

import com.boutique.dao.CompteRepository;
import com.boutique.dao.RoleRepository;
import com.boutique.dao.UserRepository;
import com.boutique.dto.RoleDTO;
import com.boutique.dto.UserDTO;
import com.boutique.dto.UserDTODetails;
import com.boutique.exception.NotExistException;
import com.boutique.model.Compte;
import com.boutique.model.Role;
import com.boutique.model.User;

@RestController
@CrossOrigin
public class UserController {
	
	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	@PostMapping("/saveUser")
	public UserDTO saveUser(@RequestBody UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		userDTO = modelMapper.map(userRepository.save(user), UserDTO.class);
		return userDTO;
	}
	
	@PostMapping("/saveUserDetails")
	public UserDTODetails saveUserDetails(@RequestBody UserDTODetails userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		
		user.setRoles(new ArrayList<>());
		user.setCompte(null);
		user = userRepository.save(user);
		if(userDTO.getCompte() != null) {
			System.out.println("entrer dans user_compte");
			Compte compte = modelMapper.map(userDTO.getCompte(),Compte.class);
			compte.setPersonne(user);
			compte=compteRepository.save(compte);
			user.setCompte(compte);
		}
		if(userDTO.getRoles() != null) {
			System.out.println("entere dans user_role");
			ArrayList<Role> listRole=new ArrayList<>();
			ArrayList<User> listUser = new ArrayList<User>();
			listUser.add(user);
			for (RoleDTO roleDTO : userDTO.getRoles()) {
				Optional<Role> oRole = roleRepository.findById(roleDTO.getIdRole());
				if(oRole.isPresent()) {
					Role role = oRole.get();
					role.setUsers(listUser);
					listRole.add(role);
				}
			}
			user.setRoles(listRole);
			user = userRepository.save(user);
		}
		
		
		return modelMapper.map(user, UserDTODetails.class);
	}
	
	
	
	@GetMapping("/getAllUser")
	public List<UserDTO> getAllUser(){
		List<User> users= userRepository.findAll();
		List<UserDTO> list = new ArrayList<UserDTO>(users.size());
		for (User user : users) {
			UserDTO userDTO = modelMapper.map(user,UserDTO.class);
			list.add(userDTO);
		}
		return list;
	}
	
	@GetMapping("/getUserDetailsById{id}")
	public UserDTODetails getUserDetailsById(@PathVariable long id) {
		Optional<User> oUser = userRepository.findById(id);
		if(!oUser.isPresent()) {
			throw new NotExistException("aucun user avec id : "+id);
		}
		return modelMapper.map(oUser.get(), UserDTODetails.class);
	}
	
	@GetMapping("/getAllUserDetails")
	public List<UserDTODetails> getAllUserDetails(){
		List<User> users= userRepository.findAll();
		List<UserDTODetails> list = new ArrayList<UserDTODetails>(users.size());
		for (User user : users) {
			UserDTODetails userDTO = modelMapper.map(user,UserDTODetails.class);
			list.add(userDTO);
		}
		return list;
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public  boolean deleteUserById (@PathVariable long id) {
		Optional<User> oUser = userRepository.findById(id);
		if(!oUser.isPresent()) {
			throw new NotExistException("aucun user avec id : "+id);
		}
		userRepository.deleteById(id);
		return true;
	}
	
	@DeleteMapping("/deleteAllUser")
	public  boolean deleteUserById () {
		
		userRepository.deleteAll();
		return true;
	}

}

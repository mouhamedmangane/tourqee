package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.CompteDTODetails;
import com.boutique.dto.RoleDTO;
import com.boutique.dto.UserDTO;
import com.boutique.dto.UserDTODetails;
import com.boutique.model.Role;
import com.boutique.model.User;

@Mapper(componentModel="spring",uses= {PersonneMapper.class,CompteMapper.class,AdresseMapper.class})
public interface UserMapper {
	UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
	
	UserDTO userToUserDTO(User user);
	User userDTOToUser(UserDTO userDTO);
	
	UserDTODetails userToUserDTODetails(User user);
	User userDTODetailsToUser(UserDTODetails userDTODetails);
	
	Role roleDTOToRole(RoleDTO roleDTO);
	RoleDTO roleToRoleDTO(Role role);
	
	
	default String RoleDTOToString(RoleDTO roleDTO) {
		return roleDTO.getNom();
	}
	
	default RoleDTO StringToRoleDTO(String nomRole) {
		RoleDTO roleDTO=new RoleDTO();
		roleDTO.setNom(nomRole);
		return roleDTO;
	}
	
}
  
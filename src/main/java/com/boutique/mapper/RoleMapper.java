package com.boutique.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.boutique.dto.RoleDTO;
import com.boutique.model.Role;

@Mapper(componentModel="spring")
public interface RoleMapper {
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	RoleDTO roleToRoleDTO(Role role);
	Role roleDTOToRole(RoleDTO roleDTO);
	
	
}

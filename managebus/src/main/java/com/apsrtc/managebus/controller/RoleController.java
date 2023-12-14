package com.apsrtc.managebus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apsrtc.managebus.entity.Role;
import com.apsrtc.managebus.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping({"/newRole"})
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	
	}

}

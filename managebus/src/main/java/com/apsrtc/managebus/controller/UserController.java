package com.apsrtc.managebus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.apsrtc.managebus.entity.User;
import com.apsrtc.managebus.service.UserService;

import javax.annotation.PostConstruct;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void callRoleAndUser() {
		userService.initRoleAndUser();
	}
	
	@PostMapping({"/registerUser"})
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@GetMapping({"/forUser"})
	@PreAuthorize("hasAnyRole('User','Admin')")
	public String forUser(){
		return "this url for users and Admin";
	}
	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This url is for admin";
	}

}

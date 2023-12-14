package com.apsrtc.managebus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsrtc.managebus.DTO.RegisterDTO;
import com.apsrtc.managebus.entity.User;
import com.apsrtc.managebus.service.UserService;

import jakarta.annotation.PostConstruct;

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
	

}

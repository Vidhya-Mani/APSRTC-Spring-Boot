package com.apsrtc.managebus.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apsrtc.managebus.dao.RoleDao;
import com.apsrtc.managebus.dao.UserDao;
import com.apsrtc.managebus.entity.Role;
import com.apsrtc.managebus.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * public void initRoleAndUser() {
	 * 
	 * Role adminRole = new Role(); adminRole.setRole("Admin");
	 * adminRole.setRoleDescription("Admin permissions update/delete");
	 * roleDao.save(adminRole);
	 * 
	 * Role userRole = new Role(); userRole.setRole("User");
	 * userRole.setRoleDescription("Default role for all new users");
	 * roleDao.save(userRole);
	 * 
	 * User adminUser = new User(); adminUser.setName("vidhya");
	 * adminUser.setPassword(getEncodedPassword("vid123")); adminUser.setAge(22);
	 * adminUser.setEmail("vidhya@gmail.com"); Set<Role> adminRoles = new
	 * HashSet<>(); adminRoles.add(adminRole); adminUser.setRole(adminRoles);
	 * userDao.save(adminUser);
	 * 
	 * 
	 * User user = new User(); user.setName("dharun");
	 * user.setPassword(getEncodedPassword("dha123")); user.setAge(7);
	 * user.setEmail("dharun@gmail.com"); Set<Role> userRoles = new HashSet<>();
	 * userRoles.add(userRole); user.setRole(userRoles); userDao.save(user);
	 * 
	 * }
	 */

	public User registerUser(User user) {

		Role role = roleDao.findById("User").get();
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setPassword(getEncodedPassword(user.getPassword()));

		return userDao.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}

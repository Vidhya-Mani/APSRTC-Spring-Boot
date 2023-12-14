package com.apsrtc.managebus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsrtc.managebus.dao.RoleDao;
import com.apsrtc.managebus.entity.Role;

@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	public Role createNewRole(Role role) {
		return roleDao.save(role);
	}

}

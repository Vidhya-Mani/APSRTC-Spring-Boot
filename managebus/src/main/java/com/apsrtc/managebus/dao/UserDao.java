package com.apsrtc.managebus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsrtc.managebus.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{
	
}

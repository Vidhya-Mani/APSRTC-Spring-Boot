package com.apsrtc.managebus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsrtc.managebus.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, String>{


}

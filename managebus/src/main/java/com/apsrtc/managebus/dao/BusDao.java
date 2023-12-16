package com.apsrtc.managebus.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsrtc.managebus.entity.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus, Long>{

	Optional<Bus> findByRegistrationNumber(String registrationNumber);

}

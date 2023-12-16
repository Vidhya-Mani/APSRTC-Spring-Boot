package com.apsrtc.managebus.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apsrtc.managebus.dto.BusDto;
import com.apsrtc.managebus.entity.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus, Long>{

	Optional<Bus> findByRegistrationNumber(String registrationNumber);
	
	 @Query("SELECT new com.apsrtc.managebus.dto.BusDto(b.registrationNumber, b.type) FROM Bus b JOIN b.schedules s JOIN s.route r WHERE r.routeName = :routeName")
	    List<BusDto> findAllBusesForRoute(@Param("routeName") String routeName);
	 
}

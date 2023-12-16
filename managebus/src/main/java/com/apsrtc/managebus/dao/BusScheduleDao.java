package com.apsrtc.managebus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apsrtc.managebus.entity.BusSchedule;

@Repository
public interface BusScheduleDao extends JpaRepository<BusSchedule, Long>{
	
	    //@Query("SELECT bs FROM BusSchedule bs WHERE bs.id = :id")
	    List<BusSchedule> findByBusId(@Param("busId") Long id);
}

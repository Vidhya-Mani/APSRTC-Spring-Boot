package com.apsrtc.managebus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsrtc.managebus.entity.BusSchedule;

@Repository
public interface BusScheduleDao extends JpaRepository<BusSchedule, Long>{

}

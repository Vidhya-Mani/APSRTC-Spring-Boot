package com.apsrtc.managebus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsrtc.managebus.entity.BusRoute;

@Repository
public interface BusRouteDao extends JpaRepository<BusRoute, Long>{

}

package com.apsrtc.managebus.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsrtc.managebus.entity.Bus;
import com.apsrtc.managebus.entity.BusRoute;

@Repository
public interface BusRouteDao extends JpaRepository<BusRoute, Long>{

	Optional<BusRoute> findByRouteName(String routeName);

}

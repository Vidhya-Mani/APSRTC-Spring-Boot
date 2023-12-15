package com.apsrtc.managebus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsrtc.managebus.dao.BusDao;
import com.apsrtc.managebus.entity.Bus;


@Service
public class BusService {
	@Autowired
	private BusDao busDao;
	
	public List<Bus> getBus() {
		return busDao.findAll();
	}
	
	public Bus addNewBus(Bus bus) {
		return busDao.save(bus);	
	}
	
	public Bus findById(Long id) {
        Optional<Bus> optionalBus = busDao.findById(id);
        return optionalBus.orElse(null);
    }

    public Bus saveBus(Bus bus) {
        return busDao.save(bus);
    }
	
	public void deleteBus(Long busId) {	
		boolean exists = busDao.existsById(busId);
		if(!exists) {
			throw new IllegalStateException("student with id" + busId + "does not exist");
		}
		busDao.deleteById(busId);
	}
}

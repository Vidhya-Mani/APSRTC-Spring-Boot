package com.apsrtc.managebus.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsrtc.managebus.dao.BusDao;
import com.apsrtc.managebus.dao.BusRouteDao;
import com.apsrtc.managebus.dao.BusScheduleDao;
import com.apsrtc.managebus.entity.Bus;
import com.apsrtc.managebus.entity.BusRoute;
import com.apsrtc.managebus.entity.BusSchedule;
import com.apsrtc.managebus.exceptions.BusNotFoundException;
import com.apsrtc.managebus.exceptions.RouteNotFoundException;
import com.apsrtc.managebus.exceptions.ScheduleOverlapException;


@Service
public class BusService {
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private BusScheduleDao busScheduleDao;
	
	@Autowired
	private BusRouteDao busRouteDao;
	
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
	
	@Transactional
    public void mapScheduleToBus(Long busId, String registrationNumber, String routeName, LocalDateTime startTime, LocalDateTime endTime)
            throws ScheduleOverlapException, BusNotFoundException, RouteNotFoundException {

        // Find the bus by registration number
        Bus bus = busDao.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new BusNotFoundException("Bus not found with registration number: " + registrationNumber));

        // Find the route by name
        BusRoute route = busRouteDao.findByRouteName(routeName)
                .orElseThrow(() -> new RouteNotFoundException("Route not found with name: " + routeName));

        // Check for schedule overlap
        if (hasScheduleOverlap(busId, startTime, endTime)) {
            throw new ScheduleOverlapException("Schedule overlaps with an existing schedule for the bus.");
        }

        // Create a new schedule
        BusSchedule schedule = new BusSchedule();
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setRoute(route);
        
       // Set the bus on the schedule
        schedule.setBus(bus);

        // Link the schedule to the bus
        bus.getSchedules().add(schedule);
        busDao.save(bus);
    }

    private boolean hasScheduleOverlap(Long busId, LocalDateTime proposedStartTime, LocalDateTime proposedEndTime) {
    	
    	List<BusSchedule> existingSchedules = busScheduleDao.findByBusId(busId);

    	
        for (BusSchedule existingSchedule : existingSchedules) {
            LocalDateTime existingStartTime = existingSchedule.getStartTime();
            LocalDateTime existingEndTime = existingSchedule.getEndTime();
            
         // Check for overlap condition: proposedStartTime is between existingStartTime and existingEndTime
            if ((proposedStartTime.isAfter(existingStartTime) || proposedStartTime.isEqual(existingStartTime))
                    && proposedStartTime.isBefore(existingEndTime)) {
                return true;
            }

            // Check for overlap condition: proposedEndTime is between existingStartTime and existingEndTime
            if (proposedEndTime.isAfter(existingStartTime) && (proposedEndTime.isBefore(existingEndTime) || proposedEndTime.isEqual(existingEndTime))) {
                return true;
            }

            // Check for overlap condition: existingStartTime is between proposedStartTime and proposedEndTime
            if ((existingStartTime.isAfter(proposedStartTime) || existingStartTime.isEqual(proposedStartTime))
                    && existingStartTime.isBefore(proposedEndTime)) {
                return true;

            /*if ((newStartTime.isAfter(existingStartTime) && newStartTime.isBefore(existingEndTime)) ||
                (newEndTime.isAfter(existingStartTime) && newEndTime.isBefore(existingEndTime)) ||
                (newStartTime.isBefore(existingStartTime) && newEndTime.isAfter(existingEndTime))) {
                return true; // Overlapping schedule
*/            
            }
        }
        return false; // No overlap
    }

}

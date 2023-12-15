package com.apsrtc.managebus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsrtc.managebus.entity.Bus;
import com.apsrtc.managebus.service.BusService;


@RestController
@RequestMapping("api/busDetail")
public class BusController {
	
	@Autowired
	private BusService busService;
	
	
	@PostMapping
	@PreAuthorize("hasAnyRole('User','Admin')")
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        Bus savedBus = busService.addNewBus(bus);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }
	
	@GetMapping
	@PreAuthorize("hasAnyRole('User','Admin')")
	public List<Bus> getBus()  {
		return busService.getBus();
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus updatedBus) {
        Bus existingBus = busService.findById(id);

        if (existingBus != null) {
            // Update the existing bus with the new details
            existingBus.setRegistrationNumber(updatedBus.getRegistrationNumber());
            existingBus.setType(updatedBus.getType());

            // Save the updated bus
            Bus savedBus = busService.saveBus(existingBus);

            return new ResponseEntity<>(savedBus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/{busId}")
	@PreAuthorize("hasRole('Admin')")
	public String delBus(@PathVariable("busId") Long busId) {
		busService.deleteBus(busId);
		return "Bus deleted successfully";
	}
	

}

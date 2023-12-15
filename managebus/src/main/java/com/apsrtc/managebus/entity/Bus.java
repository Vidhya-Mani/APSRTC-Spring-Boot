package com.apsrtc.managebus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus_detail")
public class Bus {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_number", unique = true)
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private BusType type;

	/*
	 * @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
	 * private List<BusSchedule> schedules;
	 */
    
    public enum BusType {
        ORDINARY,
        DELUXE
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public BusType getType() {
		return type;
	}

	public void setType(BusType type) {
		this.type = type;
	}

    
}

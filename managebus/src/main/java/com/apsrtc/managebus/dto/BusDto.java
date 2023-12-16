package com.apsrtc.managebus.dto;

import com.apsrtc.managebus.entity.Bus.BusType;

public class BusDto {
	 private String registrationNumber;
	 private BusType type;

	    public BusDto(String registrationNumber, BusType type) {
	        this.registrationNumber = registrationNumber;
	        this.type = type;
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

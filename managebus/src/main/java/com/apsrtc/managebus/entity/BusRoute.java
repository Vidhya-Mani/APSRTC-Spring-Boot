package com.apsrtc.managebus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus_route")
public class BusRoute {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "route_name", unique = true)
	    private String routeName;
	    
	    private String start_place;
		private String end_place;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRouteName() {
			return routeName;
		}
		public void setRouteName(String routeName) {
			this.routeName = routeName;
		}
		public String getStart_place() {
			return start_place;
		}
		public void setStart_place(String start_place) {
			this.start_place = start_place;
		}
		public String getEnd_place() {
			return end_place;
		}
		public void setEnd_place(String end_place) {
			this.end_place = end_place;
		}
		public BusRoute(String routeName, String start_place, String end_place) {
			this.routeName = routeName;
			this.start_place = start_place;
			this.end_place = end_place;
		}
		

}

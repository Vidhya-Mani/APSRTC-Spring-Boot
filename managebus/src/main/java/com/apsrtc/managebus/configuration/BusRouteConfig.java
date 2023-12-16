package com.apsrtc.managebus.configuration;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apsrtc.managebus.dao.BusRouteDao;
import com.apsrtc.managebus.entity.BusRoute;



@Configuration
public class BusRouteConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(BusRouteDao repository) {
		return args -> {
			
				BusRoute routeBC =	new BusRoute(
							"routeBC",
							"Bangalore",
							"Chennai"
							);
				BusRoute routeBH =	new BusRoute(
							"routeBH",
							"Bangalore",
							"Hyderabad"
							);
				BusRoute routeBG =	new BusRoute(
						"routeBG",
						"Bangalore",
						"Goa"
						);
				BusRoute routeBK =	new BusRoute(
						"routeBK",
						"Bangalore",
						"Kerala"
						);
				BusRoute routeBM =	new BusRoute(
						"routeBM",
						"Bangalore",
						"Mumbai"
						);
				BusRoute routeCB =	new BusRoute(
						"routeCB",
						"Chennai",
						"Bangalore"
						);
				BusRoute routeHB =	new BusRoute(
						"routeHB",
						"Hyderabad",
						"Bangalore"
						);
				BusRoute routeGB =	new BusRoute(
						"routeGB",
						"Goa",
						"Bangalore"
						);
				BusRoute routeKB =	new BusRoute(
						"routeKB",
						"Kerala",
						"Bangalore"
						);
				BusRoute routeMB =	new BusRoute(
						"routeMB",
						"Mumbai",
						"Bangalore"
						);
				
			//repository.saveAll(List.of(routeBC,routeBH,routeBG,routeBK,routeBM,routeCB,routeHB,routeGB,routeKB,routeMB));
		};
	}
	

}

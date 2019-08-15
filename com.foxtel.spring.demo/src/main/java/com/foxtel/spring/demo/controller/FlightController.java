package com.foxtel.spring.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foxtel.spring.demo.controller.interfaces.EnableAccessControl;
import com.foxtel.spring.demo.model.Flight;
import com.foxtel.spring.demo.service.FlightService;

/**
 * Controller class for defining the API endpoints for fetching flights
 * 1. flying into an airport
 * 2. flying out from an airport
 * 3. between airports
 */
@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Endpoint to fetch flights flying into an airport by airportId
	 * 
	 * @param airportId
	 * @return flights
	 */
	@EnableAccessControl("dwarf")
	@RequestMapping(value = "/in/airport/{airportId}", method = RequestMethod.GET, produces = "application/json")
	public List<Flight> getAllFlightsIn(@PathVariable String airportId) {
		
		logger.info("===============Flights IN API called===============");
		
		List<Flight> flightsIn = flightService.getAllFlightsIn(airportId);

		return flightsIn;
	}

	/**
	 * Endpoint to fetch flights flying out from an airport by airportId
	 * 
	 * @param airportId
	 * @return flights
	 */
	@EnableAccessControl("hobbit")
	@RequestMapping(value = "/out/airport/{airportId}", method = RequestMethod.GET, produces = "application/json")
	public List<Flight> getAllFlightsOut(@PathVariable String airportId) {

		logger.info("===============Flights OUT API called===============");
				
		List<Flight> flightsOut = flightService.getAllFlightsOut(airportId);

		return flightsOut;
	}

	/**
	 * Endpoint to fetch flights flying between airports by source and destination
	 * airportIds
	 * 
	 * @param sourceAirportId
	 * @param destinationAirportId
	 * @return flights
	 */
	@EnableAccessControl("wizard")
	@RequestMapping(value = "/route/source/{sourceAirportId}/dest/{destinationAirportId}", method = RequestMethod.GET, produces = "application/json")
	public List<Flight> getFlightsFromAndToAirports(@PathVariable String sourceAirportId,
			@PathVariable String destinationAirportId) {
		
		logger.info("===============Flights ROUTE API called===============");
		
		List<Flight> flightsBetweenAirports = flightService.getAllFlightsBetweenAirportsByAirportId(sourceAirportId,
				destinationAirportId);

		return flightsBetweenAirports;
	}
}

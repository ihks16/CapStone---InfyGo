package com.infy.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DTO.FlightDetailsDTO;
import com.infy.Entity.FlightDetails;
import com.infy.Service.FlightService;

@RestController
@RequestMapping("/flight")
@Validated
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping
	public ResponseEntity<String> addFlight(@Valid @RequestBody FlightDetailsDTO flightDetailsdto){
		flightService.addFlight(flightDetailsdto);
		return new ResponseEntity<String>("Flight added successfully", HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public List<FlightDetailsDTO> getAllflights(){
		return flightService.getAllFlights();
	}
	
	@GetMapping("/source")
	public List<FlightDetailsDTO> findBySource(@RequestParam("city") String city){
		return flightService.findBYSource(city);
	}
	

	@GetMapping("/destination")
	public List<FlightDetailsDTO> findByDestination(@RequestParam("city") String city){
		return flightService.findBYDestination(city);
	}
	@GetMapping("/search")
	public List<FlightDetailsDTO> searchFlight( @RequestParam("source") @NotNull(message = "source can not empty")String source,
												@RequestParam("destination")@NotNull(message = "destination can not empty") String destination ,
												@RequestParam("journeydate")	
													@FutureOrPresent(message = "please ennter Future Date") Date date){
		System.out.println(" "+source +" " +destination+ " "+ date);
		List<FlightDetailsDTO> flightDetailsdtos = flightService.searchFlight(source, destination, date);
		
		return flightDetailsdtos;
	}
}

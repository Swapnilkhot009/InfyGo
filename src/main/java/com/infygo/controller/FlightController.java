package com.infygo.controller;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infygo.DTO.FlightDTO;
import com.infygo.exceptions.AlreadyExistsException;
import com.infygo.exceptions.FlightUnavailabeException;
import com.infygo.service.FlightService;


@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping("/add")
	public ResponseEntity<FlightDTO> addFlight(@Valid @RequestBody FlightDTO flightDTO ) throws AlreadyExistsException{
		System.out.println("Flighr Fto in Controller:"+flightDTO.getFlightAvailableDate());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(flightService.addNewFlight(flightDTO)); 
	}
	
	@GetMapping("/sources")
	public ResponseEntity<Set<String>> flightSources(){
		return ResponseEntity.ok(flightService.getFlightSources());
	} 
	
	
	@GetMapping("/destinations")
	public ResponseEntity<Set<String>> flightdestinations(){
		return ResponseEntity.ok(flightService.getFlightDestinations());
	} 
	
	@GetMapping(value="/{source}/{destination}/{journeydate}")
	public ResponseEntity<Set<FlightDTO>> flightFromSrcToDestOnDate(
			@MatrixVariable(pathVar = "source")Map<String,List<String>> source,
			@MatrixVariable(pathVar = "destination")Map<String,List<String>> destination,
			@MatrixVariable(pathVar = "journeydate")Map<String,List<String>> journeyDate) 
					throws ParseException, FlightUnavailabeException{
		
		Set<String> sourceKeySet =source.keySet();
		Set<String> destinationKeySet =destination.keySet();
		Set<String> journeyDateKeySet =journeyDate.keySet();
		
		List<String> sourceSet = new ArrayList<>();
		for(String key:sourceKeySet) {
			for(int i=0;i<source.get(key).size();i++)
				sourceSet.add(source.get(key).get(i));
		}
		List<String> destinationSet = new ArrayList<>();
		for(String key:destinationKeySet) {
			for(int i=0;i<destination.get(key).size();i++)
				destinationSet.add(destination.get(key).get(i));
		}
		List<LocalDate> journeyDateSet = new ArrayList<>();
		for(String key:journeyDateKeySet) {
			for(int i=0;i<journeyDate.get(key).size();i++) {
				journeyDateSet.add(LocalDate.parse(journeyDate.get(key).get(i)));
			}
		}
		
		return ResponseEntity.ok().body(flightService.
				getflightFromSrcToDestOnDate(sourceSet, destinationSet, journeyDateSet));
	}
	
	@GetMapping("/details")
	public void  flightDeails(@RequestParam("flightId") String flightId) {
		flightService.getflightDeails(flightId);
	}
	
}

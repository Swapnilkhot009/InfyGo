package com.infygo.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infygo.DTO.FlightDTO;
import com.infygo.entity.Flight;
import com.infygo.entity.Ticket;
import com.infygo.exceptions.AlreadyExistsException;
import com.infygo.exceptions.FlightUnavailabeException;
import com.infygo.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private Environment environment;
	
	public FlightDTO addNewFlight(FlightDTO flightDTO) throws AlreadyExistsException{
		System.out.println("Flight Dto date id:"+flightDTO.getFlightAvailableDate());
		Optional<Flight> optional=flightRepository.findById(flightDTO.getFlightId());
		if(optional.isEmpty()) {
			Flight flight = modelMapper.map(flightDTO, Flight.class);
			System.out.println("Flight Dto date id:"+flightDTO.getFlightAvailableDate());
			flightRepository.saveAndFlush(flight);
			return modelMapper.map(flight,FlightDTO.class);
		}else {
			throw new AlreadyExistsException(environment.getProperty("Already.Exists"));
		}
		
	}

	public Set<String> getFlightSources() {
		Set<String> sourcesList = flightRepository.findAll().stream().
				map(flight->flight.getSource()).collect(Collectors.toSet());
		
			return sourcesList; 
	}

	public Set<String> getFlightDestinations() {
		Set<String> sourcesList = flightRepository.findAll().stream().
				map(flight->flight.getDestination()).collect(Collectors.toSet());
		
			return sourcesList; 
	}

	public Set<FlightDTO>  getflightFromSrcToDestOnDate(List<String> sourceSet, List<String> destinationSet,
			List<LocalDate> journeyDateSet) throws FlightUnavailabeException {
		
		Set<FlightDTO> flightDTOs=new HashSet<>();
		
		for(int i=0,j=0;i<sourceSet.size()&&j<destinationSet.size();i++,j++) {
			Set<Flight> flights =flightRepository.findBySourceAndDestinationAndFlightAvailableDate
			(sourceSet.get(i),destinationSet.get(i),journeyDateSet.get(i));
			
			for(Flight flight:flights) {
				FlightDTO flightDTO = modelMapper.map(flight, FlightDTO.class);
				flightDTOs.add(flightDTO);
			}
		}	
		if(flightDTOs.isEmpty()) {
		 throw new FlightUnavailabeException(environment.getProperty("Flight.Unavailable"));
		}
		return flightDTOs;
	}

	@Transactional
	public void updateTicket(Flight flight, Ticket ticket) {
		flight.setSeatCount(flight.getSeatCount()-ticket.getNoOfSeats());
		flightRepository.save(flight);
	}
	public void getflightDeails(String flightId) {
		Optional<Flight> op = flightRepository.findById(flightId);
		Flight flight =op.get();
		System.err.println(flight.toString());
	}
}
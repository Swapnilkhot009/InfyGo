package com.infygo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infygo.DTO.TicketDTO;
import com.infygo.exceptions.FlightUnavailabeException;
import com.infygo.exceptions.InvalidCredentialsException;
import com.infygo.exceptions.NotExstingException;
import com.infygo.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping(value="/book/{FlightId}/{UserId}")
	public ResponseEntity< Set<TicketDTO> > book(
			@MatrixVariable(pathVar = "FlightId")Map<String,List<String>> flightId,
			@MatrixVariable(pathVar = "UserId")Map<String,List<String>> userId) 
					throws InvalidCredentialsException, FlightUnavailabeException, NotExstingException{
		
		
		Set<String> flightIdKeySet =flightId.keySet();
		Set<String> userIdKeySet =userId.keySet();
		
		
		List<String> flightIdSet = new ArrayList<>();
		for(String key:flightIdKeySet) {
			for(int i=0;i<flightId.get(key).size();i++)
				flightIdSet.add(flightId.get(key).get(i));
		}
		System.out.println(flightIdSet);
		List<String> userIdSet = new ArrayList<>();
		for(String key:userIdKeySet) {
			for(int i=0;i<userId.get(key).size();i++)
				userIdSet.add(userId.get(key).get(i));
		}
		System.out.println(userIdSet);
	  return ResponseEntity.ok(ticketService.bookticket(flightIdSet,userIdSet));
	}
}

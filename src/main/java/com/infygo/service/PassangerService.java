package com.infygo.service;

import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infygo.entity.Passanger;
import com.infygo.entity.Ticket;
import com.infygo.repository.PassangerRepository;

@Service
public class PassangerService {
	public static Scanner scan =new Scanner(System.in); 
	@Autowired
	private PassangerRepository passangerRepository; 
	
	public void addPassanger(Set<Passanger> Passanger,Ticket ticket) {

		for(Passanger p :Passanger) {
			p.setTicket(ticket);
			passangerRepository.save(p);
			
	}
}
}
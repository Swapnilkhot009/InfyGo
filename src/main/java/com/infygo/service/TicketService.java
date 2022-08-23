package com.infygo.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infygo.DTO.TicketDTO;
import com.infygo.entity.Flight;
import com.infygo.entity.Passanger;
import com.infygo.entity.Ticket;
import com.infygo.entity.User;
import com.infygo.exceptions.FlightUnavailabeException;
import com.infygo.exceptions.InvalidCredentialsException;
import com.infygo.exceptions.NotExstingException;
import com.infygo.repository.FlightRepository;
import com.infygo.repository.TicketRepository;
import com.infygo.repository.UserRepository;

@Service
public class TicketService {
  
	public static Scanner scan =new Scanner(System.in); 
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private FlightService flightService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CreditCardService creditCardService;
	@Autowired
	private Environment environment;

	@Autowired
	private PassangerService passangerService;
	
	public Set<TicketDTO> bookticket(List<String> flightIdSet, List<String> userIdSet) 
			throws InvalidCredentialsException, FlightUnavailabeException, NotExstingException {
		Set<TicketDTO> tickets = new HashSet<>();
		Random random = new Random();
		for(int i=0,j=0;i<flightIdSet.size() && j<userIdSet.size();i++,j++) {
			Ticket ticket= new Ticket();
			Set<Passanger> passangers= new HashSet<>();
			Integer pnr = random.nextInt((Integer.MAX_VALUE - 0) + 0) + 1;
//			Optional<Flight> optionalFlight = flightRepository.findById(flightIdSet.get(i));
//			Flight flight =new Flight();
			Flight flight =flightRepository.findById(flightIdSet.get(i)).orElse(null);
//			Optional<User> optionalUser = userRepository.findById(userIdSet.get(i));
//			User user=new User();
			User user=userRepository.findById(userIdSet.get(i)).orElse(null);
			if(user==null) {
				System.out.println("User is null");
			}else {
				System.out.println("Got the user");
			}
			ticket.setPnr(pnr);
			ticket.setBooking_date(LocalDate.now());
			ticket.setDepartureTime(flight.getDepartureTime());
			ticket.setDepartureDate(flight.getFlightAvailableDate());
			
			System.out.println("New Ticket Generated");
			System.out.println("==============================================");
			System.out.println("Enter number of seats to book");
			Integer seats = scan.nextInt();
			if(!(seats<=flight.getSeatCount())) {
				throw new FlightUnavailabeException(environment.getProperty("Flight.Unavailable"));
			}else {
				ticket.setNoOfSeats(seats);
				for(int seat=1;seat<seats+1;seat++) {
					Passanger passanger = new Passanger();
					System.out.println("Enter Id for passanger:"+ seat);
					Integer passangerId = scan.nextInt();
					passanger.setPassangerId(passangerId);
					System.out.println("Enter Age for passanger:"+ seat);
					String age = scan.next();
					passanger.setPassangeraAge(age);
					System.out.println("Enter gender of passanger:"+ seat);
					String gender = scan.next();
					passanger.setPassangerGender(gender);
					System.out.println("Enter name of passanger:"+ seat);
					String name = scan.next();
					passanger.setPassangerName(name);
					passangers.add(passanger);
				}	
			}
			System.out.println("User id:"+userIdSet.get(i));
			ticket.setFlight(flight);
			ticket.setUser(user);
			ticket.setTotalFare(flight.getFare()*seats); 
			creditCardService.updateBill(user,ticket.getTotalFare());
			passangerService.addPassanger(passangers,ticket);
			flightService.updateTicket(flight, ticket);
			ticketRepository.save(ticket);
			System.out.println("Ticket bookSuccessfully");
			tickets.add(modelMapper.map(ticket,TicketDTO.class));
		}
		return tickets;
	}

}

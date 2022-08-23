package com.infygo.DTO;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



public class FlightDTO {
	
	private String flightId;
	private String airlines;
	private String arrivalTime;
	private String departureTime;
	private String destination;
	private double fare;
	
	private LocalDate flightAvailableDate;
	private Integer seatCount;
	private String source;
	
	private Set<TicketDTO> tickets=new HashSet<>(); 

	public FlightDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightDTO(String flightId, String airlines, String arrivalTime, String departureTime, String destination,
			double fare, LocalDate flightAvailableDate, Integer seatCount, String source) {
		super();
		this.flightId = flightId;
		this.airlines = airlines;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.destination = destination;
		this.fare = fare;
		this.flightAvailableDate = flightAvailableDate;
		this.seatCount = seatCount;
		this.source = source;
	}
	
	public Set<TicketDTO> getTickets() {
		return tickets;
	}

	public void setTickets(Set<TicketDTO> tickets) {
		this.tickets = tickets;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalDate getFlightAvailableDate() {
		return flightAvailableDate;
	}

	public void setFlightAvailableDate(LocalDate flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "FlightDTO [flightId=" + flightId + ", airlines=" + airlines + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", destination=" + destination + ", fare=" + fare
				+ ", flightAvailableDate=" + flightAvailableDate + ", seatCount=" + seatCount + ", source=" + source
				+ ", tickets=" + tickets + "]";
	}
	
	
}

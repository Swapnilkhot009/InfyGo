package com.infygo.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Flight {
	
	@Id
	@NotNull(message="Flight id cannot be null")
	private String flightId;
	@Column(length = 15)
	private String airlines;
	@Column
	private String arrivalTime;
	@Column
	private String departureTime;
	@Column(length = 15)
	@NotNull
	private String destination;
	@Column
	@Min(value=0)
	@Max(value=100000)
	private double fare;
	@Column
	@FutureOrPresent(message = "Flight Availability cannot be in past")
	private LocalDate flightAvailableDate;
	@Column
	private Integer seatCount;
	@Column(length = 15)
	@NotNull
	private String source;
    
	@OneToMany(mappedBy = "flight",cascade = CascadeType.ALL)
	private Set<Ticket> tickets=new HashSet<>(); 
	
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(String flightId, String airlines, String arrivalTime, String departureTime, String destination,
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

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}	
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlines=" + airlines + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", destination=" + destination + ", fare=" + fare
				+ ", flightAvailableDate=" + flightAvailableDate + ", seatCount=" + seatCount + ", source=" + source
				+ ", tickets=" + tickets + "]";
	}
}

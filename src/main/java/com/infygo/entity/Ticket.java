package com.infygo.entity;



import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;


@Entity
public class Ticket {
	@Id
	@NotNull
	private Integer pnr;
	@Column
	private LocalDate bookingdate;
	@Column
	@Future(message="Daparture is always in future")
	private LocalDate departureDate;
	@Column
	private String departureTime;
	@Column
	@Min(value=1,message="Cannot book less than Zero seats")
	@Max(value=5,message="Cannot book more than five seats")
	private Integer noOfSeats;
	@Column
	private Double totalFare;
	
	@ManyToOne(targetEntity = Flight.class, cascade = CascadeType.ALL)
	@JoinColumn(name="flightId",referencedColumnName = "flightId")
	private Flight flight ;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name="userId",referencedColumnName = "userId")
	private User user ;
	
	@OneToMany(cascade =CascadeType.ALL,mappedBy = "ticket")
	private Set<Passanger> passangers = new HashSet<>();
	

	
	
	
	public Ticket(Integer pnr, LocalDate booking_date, LocalDate departureDate, String departureTime,
			Integer noOfSeats, Double totalFare) {
		super();
		this.pnr = pnr;
		this.bookingdate = booking_date;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPnr() {
		return pnr;
	}

	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}

	public LocalDate getBooking_date() {
		return bookingdate;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.bookingdate = booking_date;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	
	

	
	public LocalDate getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(LocalDate bookingdate) {
		this.bookingdate = bookingdate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Passanger> getPassangers() {
		return passangers;
	}

	public void setPassangers(Set<Passanger> passangers) {
		this.passangers = passangers;
	}

	@Override
	public String toString() {
		return "TicketDTO [pnr=" + pnr + ", booking_date=" + bookingdate + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", noOfSeats=" + noOfSeats
				+ ", totalFare=" + totalFare +"]";
	}
	
	
	

}

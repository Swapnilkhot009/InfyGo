package com.infygo.DTO;

import java.time.LocalDate;
public class TicketDTO {
	
	private Integer pnr;
	private LocalDate booking_date;
	private LocalDate departureDate;
	private String departureTime;
	private String flightId;
	private Integer noOfSeats;
	private Double totalFare;
	private String userId;
	
	
	

	public TicketDTO(Integer pnr, LocalDate booking_date, LocalDate departureDate, String departureTime, String flightId,
			Integer noOfSeats, Double totalFare, String userId) {
		super();
		this.pnr = pnr;
		this.booking_date = booking_date;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.flightId = flightId;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
		this.userId = userId;
	}

	public TicketDTO() {
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
		return booking_date;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
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

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TicketDTO [pnr=" + pnr + ", booking_date=" + booking_date + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", flightId=" + flightId + ", noOfSeats=" + noOfSeats
				+ ", totalFare=" + totalFare + ", userId=" + userId +"]";
	}
	
	
}

package com.infygo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
@Entity
public class Passanger {
	
	@Id
	@NotNull(message="Passanger Id cann't be null")
	private Integer passangerId;
	@Column(length = 4)
	@Min(value=5,message="Age less than 5 are not allowed in flight")
	private String passangeraAge;
	@Column(length = 11)
	private String passangerGender;
	@Column(length = 20)
	private String passangerName;
	
	
	@ManyToOne(targetEntity = Ticket.class, cascade = CascadeType.ALL)
	@JoinColumn(name="ticketPnr",referencedColumnName = "pnr")
	private Ticket ticket;
	
	public Passanger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passanger(Integer passangerId,String passangeraAge, 
			String passangerGender, String passangerName) {
		super();
		this.passangerId = passangerId;
		this.passangeraAge = passangeraAge;
		this.passangerGender = passangerGender;
		this.passangerName = passangerName;
		
	}
	public Integer getPassangerId() {
		return passangerId;
	}
	public void setPassangerId(Integer passangerId) {
		this.passangerId = passangerId;
	}
	public String getPassangeraAge() {
		return passangeraAge;
	}
	public void setPassangeraAge(String passangeraAge) {
		this.passangeraAge = passangeraAge;
	}
	public String getPassangerGender() {
		return passangerGender;
	}
	public void setPassangerGender(String passangerGender) {
		this.passangerGender = passangerGender;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	
	
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "PassangerDTO [passangerId=" + passangerId + ", passangeraAge=" + passangeraAge + ", passangerGender="
				+ passangerGender + ", passangerName=" + passangerName +"]";
	}
	
	

}

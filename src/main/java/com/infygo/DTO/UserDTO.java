package com.infygo.DTO;
import java.util.*;


public class UserDTO {
	private String userId;
	private String city;
	private String email;
	private String name;
	private String password;
	private String phone;
	private Set<TicketDTO> ticketsdto=new HashSet<>(); 
	
	public UserDTO(String userId, String city, String email, String name, String password, String phone) {
		super();
		this.userId = userId;
		this.city = city;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Set<TicketDTO> getTicketsdto() {
		return ticketsdto;
	}


	public void setTicketsdto(Set<TicketDTO> ticketsdto) {
		this.ticketsdto = ticketsdto;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", city=" + city + ", email=" + email + ", name=" + name + ", password="
				+ password + ", phone=" + phone + ", ticketsdto=" + ticketsdto + "]";
	}

	
}

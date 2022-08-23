package com.infygo.entity;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import javax.persistence.Id;


@Entity
public class User {
	@Id
	@NotNull
	private String userId;
	
	@Column(length = 15)
	private String city;
	
	@Column(length = 30)
	@Email
	private String email;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 20)
	@NotNull(message="Password is mandatory")
//	@Pattern(regexp = "/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/\r\n",
//	message="Password must have Uppercase letters, lowercase letters,digits and special characters")
	private String password;
	
	@Column(length = 14)
	private String phone;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Ticket> tickets=new HashSet<>(); 
	
	public User(String userId, String city, String email, String name, String password, String phone) {
		super();
		this.userId = userId;
		this.city = city;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", city=" + city + ", email=" + email + ", name=" + name + ", password="
				+ password + ", phone=" + phone + ", tickets=" + tickets + "]";
	}
}

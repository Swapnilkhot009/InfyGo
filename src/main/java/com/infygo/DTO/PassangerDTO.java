package com.infygo.DTO;



public class PassangerDTO {
	private Integer passangerId;
	private String passangeraAge;
	private String passangerGender;
	private String passangerName;
	
	
	private TicketDTO ticketdto;
	
	
	public PassangerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassangerDTO(Integer passangerId, String passangeraAge,
			String passangerGender, String passangerName) {
		super();
		this.passangerId = passangerId;
		this.passangeraAge = passangeraAge;
		this.passangerGender = passangerGender;
		this.passangerName = passangerName;
		
	}
	
	public TicketDTO getTicketdto() {
		return ticketdto;
	}
	public void setTicketdto(TicketDTO ticketdto) {
		this.ticketdto = ticketdto;
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
	@Override
	public String toString() {
		return "PassangerDTO [passangerId=" + passangerId + ", passangeraAge=" + passangeraAge + ", passangerGender="
				+ passangerGender + ", passangerName=" + passangerName + ", ticketdto=" + ticketdto + "]";
	}
	

	
	

}

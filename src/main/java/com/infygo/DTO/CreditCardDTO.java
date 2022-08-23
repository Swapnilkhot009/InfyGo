package com.infygo.DTO;
public class CreditCardDTO {
	private String cardNumberString;
	private String apin;
	private String cardNameHolderString;
	private String cvv;
	private String expiryMonth;
	private String expiryYear;
	private String totalBillString;
	public CreditCardDTO(String cardNumberString, String apin, String cardNameHolderString, String cvv,
			String expiryMonth, String expiryYear, String totalBillString) {
		super();
		this.cardNumberString = cardNumberString;
		this.apin = apin;
		this.cardNameHolderString = cardNameHolderString;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.totalBillString = totalBillString;
	}
	public CreditCardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCardNumberString() {
		return cardNumberString;
	}
	public void setCardNumberString(String cardNumberString) {
		this.cardNumberString = cardNumberString;
	}
	public String getApin() {
		return apin;
	}
	public void setApin(String apin) {
		this.apin = apin;
	}
	public String getCardNameHolderString() {
		return cardNameHolderString;
	}
	public void setCardNameHolderString(String cardNameHolderString) {
		this.cardNameHolderString = cardNameHolderString;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getTotalBillString() {
		return totalBillString;
	}
	public void setTotalBillString(String totalBillString) {
		this.totalBillString = totalBillString;
	}
	@Override
	public String toString() {
		return "CreditCardDTO [cardNumberString=" + cardNumberString + ", apin=" + apin + ", cardNameHolderString="
				+ cardNameHolderString + ", cvv=" + cvv + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear
				+ ", totalBillString=" + totalBillString + "]";
	}
	
	
	
}

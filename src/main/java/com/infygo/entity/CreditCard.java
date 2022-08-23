package com.infygo.entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Entity
public class CreditCard {
	@Id
	@NotNull
	private String cardNumber;
	@Column
	private String apin;
	@Column(length = 30)
	private String cardHolderName;
	@Column(length = 4)
	private String cvv;
	@Column
	private String expiryMonth;
	@Column
	private String expiryYear;
	@Column
	private String totalBill;
	
	public CreditCard(String cardNumber, String apin, String cardHolderName, String cvv,
			String expiryMonth, String expiryYear, String totalBill) {
		super();
		this.cardNumber = cardNumber;
		this.apin = apin;
		this.cardHolderName= cardHolderName;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.totalBill = totalBill;
	}
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCardNumberString() {
		return cardNumber;
	}
	public void setCardNumberString(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getApin() {
		return apin;
	}
	public void setApin(String apin) {
		this.apin = apin;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
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
		return totalBill;
	}
	public void setTotalBillString(String totalBillString) {
		this.totalBill = totalBillString;
	}
	@Override
	public String toString() {
		return "CreditCardDTO [cardNumberString=" + cardNumber + ", apin=" + apin + ", cardHolderName="
				+ cardHolderName + ", cvv=" + cvv + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear
				+ ", totalBillString=" + totalBill + "]";
	}
	
	
	
}

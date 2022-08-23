package com.infygo.service;

import java.util.Scanner;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infygo.entity.CreditCard;
import com.infygo.entity.User;
import com.infygo.exceptions.InvalidCredentialsException;
import com.infygo.exceptions.NotExstingException;
import com.infygo.repository.CreditCardRepository;


@Service
public class CreditCardService {
	
	@Autowired
	private CreditCardRepository creditCardRepository;	
	@Autowired
	private Environment environment;
	private  static Scanner scan=new Scanner(System.in);
	public void addNewCard() throws InvalidCredentialsException{
		CreditCard creditCard = new CreditCard();
		System.out.println("Enter 7 digit card number");
		String number= scan.next();
		if(number.length()==7) 
			creditCard.setCardNumberString(number);
		else
			throw new InvalidCredentialsException("Invalid.Credentials");
		System.out.println("Enter apin");
		String apin= scan.next();
		creditCard.setApin(apin);
		System.out.println("Enter Card Holder Name");
		String name= scan.next();
		creditCard.setCardHolderName(name);
		System.out.println("Enter 3 digit CVV number");
		String cvv= scan.next();
		if(cvv.length()==3)
			creditCard.setCvv(cvv);
		else
			throw new InvalidCredentialsException(environment.getProperty("Invalid.Credentials"));
		
		System.out.println("Enter expiary month");
		String month=scan.next();
		creditCard.setExpiryMonth(month);
		System.out.println("Enter expiary Year");
		String year=scan.next();
		creditCard.setExpiryYear(year);
		creditCard.setTotalBillString("0");
		creditCardRepository.save(creditCard);
		System.out.println("CreditCard for "+ creditCard.getCardHolderName()+
				" saved successfully");
	}
	@Transactional
	public void updateBill(User user, double bill ) throws InvalidCredentialsException, NotExstingException {
		System.out.println("Enter 7 digit card number:");
		String number = scan.next();
//		System.out.println("Getting user:"+user.getName());
//		System.out.println("User id in card:"+user.getUserId());
		if(number.length()==7) {
			CreditCard creditCard = creditCardRepository.
					findByCardNumberAndCardHolderName(number,user.getName());
			if(creditCard==null)
				throw new NotExstingException(environment.getProperty("No.CreditCard"));
			int finalBill=Integer.parseInt(creditCard.getTotalBillString())+(int)bill;
			creditCard.setTotalBillString(String.valueOf(finalBill));
			creditCardRepository.save(creditCard);
		}else {
			throw new InvalidCredentialsException(environment.getProperty("Invalid.Credentials"));
		}		
		
	}
	
	@Transactional
	public String makePayment() throws InvalidCredentialsException {
		System.out.println("Enter Card Holders Name:");
		String name = scan.next();
		System.out.println("Enter 7 digit card number:");
		String number = scan.next();
		CreditCard creditCard = creditCardRepository.
				findByCardNumberAndCardHolderName(number, name);
		if(creditCard==null) {
			System.out.println("CreditCard with given details is not availabel");
			System.exit(0);
		}
		System.out.println("Enter apin for validation:");
		String apin = scan.next();
		System.out.println("Enter CVV for validation:");
		String CVV = scan.next();
		if(!(apin.equals(creditCard.getApin()) && CVV.equals(creditCard.getCvv())))
			throw new InvalidCredentialsException("Invalid.Credentials");
		if(Integer.parseInt(creditCard.getTotalBillString())==0) {
			return environment.getProperty("No.Dues").toString();
		}
		int amount=Integer.MAX_VALUE;
		while(amount>Integer.parseInt(creditCard.getTotalBillString())){
			System.out.println("Enter amount to pay due remained:"+creditCard.getTotalBillString());
			amount = scan.nextInt();
		}
		System.out.print("Press y to pay n to cancel transaction.");
		String confirm =scan.next();
		if(confirm.equalsIgnoreCase("y")) {
			creditCard.setTotalBillString(String.valueOf
			 (Integer.parseInt(creditCard.getTotalBillString())-amount));
			creditCardRepository.save(creditCard);
		return environment.getProperty("Paid.Success");
		}else
			return environment.getProperty("Transaction.Cancel");
	}

}



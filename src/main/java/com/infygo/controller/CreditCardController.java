package com.infygo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infygo.exceptions.InvalidCredentialsException;
import com.infygo.service.CreditCardService;

@RestController
public class CreditCardController {
	
	@Autowired
	private CreditCardService creditCardService;
	
	
	@PostMapping("/new")
	public void addCard() throws InvalidCredentialsException {
		creditCardService.addNewCard();
	}
	
	@PostMapping("/payment")
	public ResponseEntity<String> payment() throws InvalidCredentialsException {
		return ResponseEntity.ok(creditCardService.makePayment());
	}
	
}

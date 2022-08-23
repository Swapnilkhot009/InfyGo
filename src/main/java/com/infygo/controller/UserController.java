package com.infygo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infygo.DTO.UserDTO;
import com.infygo.exceptions.InvalidCredentialsException;
import com.infygo.exceptions.NotExstingException;
import com.infygo.exceptions.AlreadyExistsException;
import com.infygo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO)
			throws AlreadyExistsException{
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.registerUser(userDTO));
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@Valid @RequestBody UserDTO userDTO)
			throws InvalidCredentialsException, NotExstingException{
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.userLogin(userDTO));
	}
	@GetMapping("/details")
	public void  flightDeails(@RequestParam("userId") String userId) {
		userService.getUserDeails(userId);
	}
}

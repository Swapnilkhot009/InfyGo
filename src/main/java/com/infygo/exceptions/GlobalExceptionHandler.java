package com.infygo.exceptions;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<MessageError> existingUser(AlreadyExistsException ex){
		MessageError error = new MessageError();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<MessageError> invalidCredentias(InvalidCredentialsException ex){
		MessageError error = new MessageError();
		error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(NotExstingException .class)
	public ResponseEntity<MessageError> notAUser(NotExstingException  ex){
		MessageError error = new MessageError();
		error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(FlightUnavailabeException.class)
	public ResponseEntity<MessageError> noFilight(FlightUnavailabeException ex){
		MessageError error = new MessageError();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageError> methodArgumentNotValidException(
			MethodArgumentNotValidException ex){
		MessageError error = new MessageError();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getBindingResult().getAllErrors().stream()
				.map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
		
		return new ResponseEntity<MessageError>(error,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MessageError> constraintVoilationException(
			ConstraintViolationException ex){
		MessageError error = new MessageError();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getConstraintViolations().stream()
				.map(ConstraintViolation::getMessage).collect(Collectors.joining(",")));
		
		return new ResponseEntity<MessageError>(error,HttpStatus.BAD_REQUEST);
	}	
}

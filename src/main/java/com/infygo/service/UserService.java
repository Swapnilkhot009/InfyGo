package com.infygo.service;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infygo.DTO.UserDTO;
import com.infygo.entity.User;
import com.infygo.exceptions.InvalidCredentialsException;
import com.infygo.exceptions.NotExstingException;
import com.infygo.exceptions.AlreadyExistsException;
import com.infygo.repository.UserRepository;



@Service
@PropertySource("classpath:validation.properties")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private Environment environment;
	
	
	public UserDTO registerUser(UserDTO userDTO) throws AlreadyExistsException{
		
		User user = modelMapper.map(userDTO, User.class);
		if(userRepository. getuserIdByName(user.getName())!=null) {
			throw new AlreadyExistsException(
					environment.getProperty("Already.Exists"));
		}else {
			userRepository.saveAndFlush(user);
		}
		return modelMapper.map(user, UserDTO.class);
		
	}

	public String userLogin(UserDTO userDTO) throws InvalidCredentialsException, NotExstingException{
		
	User dbUser=userRepository.findByUserId(userDTO.getUserId());
	if(dbUser==null)
		throw new NotExstingException(environment.getProperty("Not.A.User"));
	if(dbUser.getPassword().equals(userDTO.getPassword()))
		return environment.getProperty("Logged.In");
	else 
		throw new InvalidCredentialsException(environment.getProperty("Invalid.Credentials"));
	

	}

	public void getUserDeails(String userId) {
		Optional<User> op = userRepository.findById(userId);
		User user =op.get();
		System.err.println(user.toString());
		
	}
}

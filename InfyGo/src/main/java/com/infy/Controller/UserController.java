package com.infy.Controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DTO.UserDetailsDTO;
import com.infy.Entity.UserDetails;
import com.infy.Exception.UserNotExist;
import com.infy.Exception.UserAllReadyExist;
import com.infy.Repository.UserRepository;
import com.infy.Service.UserService;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/register")
	public ResponseEntity<String> addUsers(@Valid @RequestBody UserDetailsDTO userDetailsDto) throws UserAllReadyExist{
		userService.addUsers(userDetailsDto);
		
		return new  ResponseEntity<String>("user registered Successfully",HttpStatus.OK);
	}
	
	
	@GetMapping
	public List<UserDetailsDTO> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/present")
	public Boolean present(@RequestParam("name") String name,@RequestParam("phone") String phone) {
		return userService.userExistOrNot(name, phone);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDetailsDTO userDetailsDto) throws UserNotExist{
		userService.login(userDetailsDto);
		return new ResponseEntity<String>("you have login successfully",HttpStatus.ACCEPTED);
	}
}

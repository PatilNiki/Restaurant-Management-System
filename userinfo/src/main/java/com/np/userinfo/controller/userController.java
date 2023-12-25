package com.np.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.userinfo.dto.UserDto;
import com.np.userinfo.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/fetchAllUsers")
	public ResponseEntity<List<UserDto>> fetchAllUsers(){
		List<UserDto> usersDtos = userService.fetchAllUsers();
		return new ResponseEntity<>(usersDtos, HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{user_id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer user_id){
		UserDto userDto = userService.getUserById(user_id);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto user){
		UserDto userDto = userService.addUser(user);
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}
	
	

}

package com.wintercamp.piademo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wintercamp.piademo.dto.UserDTO;
import com.wintercamp.piademo.service.UserService;


@RestController
@Validated
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	

	@PostMapping("/add-user")
	public UserDTO addUser(@Valid @RequestBody UserDTO dto) {
		return userService.createUser(dto);
	}

	@GetMapping("/findAll")
	public List<UserDTO> findAll(){
		return userService.findAllUser();		
	}

}

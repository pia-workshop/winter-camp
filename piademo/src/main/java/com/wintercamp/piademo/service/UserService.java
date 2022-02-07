package com.wintercamp.piademo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wintercamp.piademo.dto.UserDTO;
import com.wintercamp.piademo.model.User;
import com.wintercamp.piademo.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDTO createUser(UserDTO userDto) {
		User existUser = new User();
		existUser = userRepository.findByUsername(userDto.getUsername());
		if(Objects.nonNull(existUser)) {
			throw new RuntimeException("Exist User");
		}
		User newUser = new User();
		newUser=mapUserDtoToUser(userDto);
		newUser.setId(UUID.randomUUID());
		newUser= userRepository.save(newUser);
		return mapUserDtoToUser(newUser);
	}
	
	public List<UserDTO> findAllUser(){
		List<User> users=userRepository.findAll();
//		List<UserDTO>userDTO= new ArrayList<UserDTO>();
//		for(User user:users) {			
//			userDTO.add(mapUserDtoToUser(user));
//		}		
		return users.stream().map(user->mapUserDtoToUser(user)).collect(Collectors.toList());
		
	}

	private User mapUserDtoToUser(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setUsername(dto.getUsername());
		user.setLastname(dto.getLastName());
		return user;
	}

	private UserDTO mapUserDtoToUser(User user) {
		UserDTO dto = new UserDTO();
		dto.setLastName(user.getLastname());
		dto.setName(user.getName());
		dto.setUsername(user.getUsername());
		return dto;
	}

}

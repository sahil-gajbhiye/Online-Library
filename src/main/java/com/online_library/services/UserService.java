package com.online_library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_library.entites.Users;
import com.online_library.repositories.UserRepository;
import com.online_library.response_command.UserResponse;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserResponse> getAllUsers() {

		List<Users> users = userRepository.findAll();

		return users.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private UserResponse convertToDto(Users users) {

		UserResponse user_response = new UserResponse();

		user_response.setUser_id(String.valueOf(users.getUser_id()));
		user_response.setUser_name(users.getUser_name());
		user_response.setUser_email(users.getUser_email());
		user_response.setUser_role(users.getUser_role());
		user_response.setMembership_start(String.valueOf(users.getMembership_start()));
		user_response.setMembership_end(String.valueOf(users.getMembership_end()));

		return user_response;
	}
}

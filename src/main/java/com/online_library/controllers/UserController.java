package com.online_library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_library.response_command.UserResponse;
import com.online_library.services.UserService;

@RestController
@RequestMapping("/api-v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserResponse>> getAllUsers() {

		List<UserResponse> users = userService.getAllUsers();

		return ResponseEntity.ok(users);
	}
}

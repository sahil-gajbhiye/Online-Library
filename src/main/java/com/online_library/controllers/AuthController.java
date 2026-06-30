package com.online_library.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_library.request_command.LoginRequest;
import com.online_library.request_command.RegisterUserRequest;
import com.online_library.response_command.LoginResponse;
import com.online_library.services.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-v1/auth")
@Validated
public class AuthController {

	private final AuthenticationService authenticationService;

	public AuthController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

		LoginResponse response = authenticationService.login(request);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterUserRequest request) {

		return ResponseEntity.ok(authenticationService.register(request));
	}
}

package com.online_library.services;

import org.springframework.stereotype.Service;

import com.online_library.entites.Users;
import com.online_library.repositories.UserRepository;
import com.online_library.request_command.LoginRequest;
import com.online_library.request_command.RegisterUserRequest;
import com.online_library.response_command.LoginResponse;
import com.online_library.security.JwtService;
import com.online_library.security.UserDetailsImpl;

import java.time.LocalDate;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private final AuthenticationManager authenticationManager;

	private final JwtService jwtService;

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService,
			UserRepository userRepository, PasswordEncoder passwordEncoder) {

		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public LoginResponse login(LoginRequest request) {

		// Authenticate username and password
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		// Get authenticated user
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		Users users = userDetails.getUser();

		// Generate JWT Token
		String token = jwtService.generateToken(userDetails);

		// Membership validation
		boolean membershipValid = false;

		if (users.getMembership_end() != null) {
			membershipValid = !users.getMembership_end().isBefore(LocalDate.now());
		}

		// Prepare response
		LoginResponse response = new LoginResponse();

		response.setToken(token);
		response.setToken_type("Bearer");
		response.setUser_id(users.getUser_id());
		response.setUser_name(users.getUser_name());
		response.setUser_email(users.getEmail());
		response.setUser_role(users.getUser_role().name());
		response.setMembershipValid(membershipValid);
		response.setMembership_end_date(users.getMembership_end());

		if (membershipValid) {
			response.setMessage("Login Successful");
		} else {
			response.setMessage("Login Successful, but Membership has expired.");
		}

		return response;
	}

	@Override
	public String register(RegisterUserRequest request) {

		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("Email already registered.");
		}

		Users users = new Users();

		users.setUser_name(request.getUserName());

		users.setEmail(request.getEmail());

		// Encrypt Password
		users.setPassword(passwordEncoder.encode(request.getPassword()));

		users.setUser_role(request.getUserRole());

		users.setMembership_start(request.getMembershipStart());

		users.setMembership_end(request.getMembershipStart().plusMonths(request.getMembershipMonths()));

		userRepository.save(users);

		return "User Registered Successfully";
	}
}

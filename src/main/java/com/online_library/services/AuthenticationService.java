package com.online_library.services;

import com.online_library.request_command.LoginRequest;
import com.online_library.request_command.RegisterUserRequest;
import com.online_library.response_command.LoginResponse;

public interface AuthenticationService {

	LoginResponse login(LoginRequest request);

	String register(RegisterUserRequest request);
}

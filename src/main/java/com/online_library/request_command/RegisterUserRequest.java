package com.online_library.request_command;

import java.time.LocalDate;

import com.online_library.enums.UserRole;

public class RegisterUserRequest {

	private String userName;

	private String email;

	private String password;

	private UserRole userRole;

	private LocalDate membershipStart;

	private Integer membershipMonths;

	public RegisterUserRequest() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public LocalDate getMembershipStart() {
		return membershipStart;
	}

	public void setMembershipStart(LocalDate membershipStart) {
		this.membershipStart = membershipStart;
	}

	public Integer getMembershipMonths() {
		return membershipMonths;
	}

	public void setMembershipMonths(Integer membershipMonths) {
		this.membershipMonths = membershipMonths;
	}

}

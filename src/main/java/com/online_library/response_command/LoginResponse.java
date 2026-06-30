package com.online_library.response_command;

import java.time.LocalDate;

public class LoginResponse {

	private String token;

	private String token_type;

	private Long user_id;

	private String user_name;

	private String user_email;

	private String user_role;

	private boolean membershipValid;

	private LocalDate membership_end_date;

	private String message;

	public LoginResponse() {
	}

	public LoginResponse(String token, String token_type, Long user_id, String user_name, String user_email,
			String user_role, boolean membershipValid, LocalDate membership_end_date, String message) {
		super();
		this.token = token;
		this.token_type = token_type;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_role = user_role;
		this.membershipValid = membershipValid;
		this.membership_end_date = membership_end_date;
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public boolean isMembershipValid() {
		return membershipValid;
	}

	public void setMembershipValid(boolean membershipValid) {
		this.membershipValid = membershipValid;
	}

	public LocalDate getMembership_end_date() {
		return membership_end_date;
	}

	public void setMembership_end_date(LocalDate membership_end_date) {
		this.membership_end_date = membership_end_date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

package com.online_library.response_command;

import com.online_library.enums.UserRole;

public class UserResponse {

	private String user_id;
	private String user_name;
	private String user_email;
	private UserRole user_role;
	private String membership_start;
	private String membership_end;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
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

	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}

	public String getMembership_start() {
		return membership_start;
	}

	public void setMembership_start(String membership_start) {
		this.membership_start = membership_start;
	}

	public String getMembership_end() {
		return membership_end;
	}

	public void setMembership_end(String membership_end) {
		this.membership_end = membership_end;
	}

}

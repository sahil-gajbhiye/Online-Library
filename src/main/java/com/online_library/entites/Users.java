package com.online_library.entites;

import java.time.LocalDateTime;

import com.online_library.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users", schema = "online_library")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "user_name", nullable = false)
	private String user_name;

	@Column(name = "user_email", nullable = false)
	private String user_email;

	@Column(name = "user_password", nullable = false)
	private String user_password;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	private UserRole user_role;

	@Column(name = "membership_start")
	private LocalDateTime membership_start;

	@Column(name = "membership_end")
	private LocalDateTime membership_end;

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

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}

	public LocalDateTime getMembership_start() {
		return membership_start;
	}

	public void setMembership_start(LocalDateTime membership_start) {
		this.membership_start = membership_start;
	}

	public LocalDateTime getMembership_end() {
		return membership_end;
	}

	public void setMembership_end(LocalDateTime membership_end) {
		this.membership_end = membership_end;
	}

}

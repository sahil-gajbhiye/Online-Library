package com.online_library.entites;

import java.time.LocalDate;

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

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	private UserRole user_role;

	@Column(name = "membership_start")
	private LocalDate membership_start;

	@Column(name = "membership_end")
	private LocalDate membership_end;

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

	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}

	public LocalDate getMembership_start() {
		return membership_start;
	}

	public void setMembership_start(LocalDate membership_start) {
		this.membership_start = membership_start;
	}

	public LocalDate getMembership_end() {
		return membership_end;
	}

	public void setMembership_end(LocalDate membership_end) {
		this.membership_end = membership_end;
	}

}

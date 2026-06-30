package com.online_library.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.online_library.entites.Users;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private final Users users;

	public UserDetailsImpl(Users users) {
		this.users = users;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(new SimpleGrantedAuthority("ROLE_" + users.getUser_role().name()));

	}

	@Override
	public String getPassword() {

		return users.getPassword();
	}

	@Override
	public String getUsername() {

		return users.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	public Users getUser() {

		return users;
	}
}

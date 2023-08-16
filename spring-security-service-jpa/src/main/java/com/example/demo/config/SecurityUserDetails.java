package com.example.demo.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.UserInfo;

import lombok.Data;

@Data
public class SecurityUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserInfo info;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return info.getUserRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return info.getUserPassword();
	}

	@Override
	public String getUsername() {
		return info.getUserName();
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

}

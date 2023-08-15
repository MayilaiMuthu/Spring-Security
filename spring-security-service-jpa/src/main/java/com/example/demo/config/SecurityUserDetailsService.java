package com.example.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = repository.findByUserName(username);
		SecurityUserDetails details = null;
		if(userInfo.isPresent()) {
			details = new SecurityUserDetails();
			details.setInfo(userInfo.get());
		}else {
			throw new UsernameNotFoundException("User Details not founded by the User :"+username);
		}
		return details;
	}

}

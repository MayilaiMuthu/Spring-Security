package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDetailsDto;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserInfoRepository;

@Service
public class LoginService {

	@Autowired
	private UserInfoRepository infoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void addUser(UserDetailsDto details) {
		Optional<UserInfo> userInfo = infoRepository.findByUserName(details.getUserName());
		if (userInfo.isPresent()) {
			throw new RuntimeException("User Name is already Exists......");
		} else {
			Set<UserRole> roles = new HashSet<>();
			roles.add(UserRole.builder().roleName("USER").build());
			UserInfo info = UserInfo.builder().userName(details.getUserName()).crDt(LocalDateTime.now())
					.userPassword(encoder.encode(details.getPassword()))
					.updDt(LocalDateTime.now()).userRoles(roles).build();
			infoRepository.save(info);
		}

	}

}

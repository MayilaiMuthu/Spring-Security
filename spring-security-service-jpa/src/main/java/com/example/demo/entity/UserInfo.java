package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.config.ApplicationConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private int userId;
	@NotNull
	@Size(min = 2, max = 25, message = "Please provide User Name is 2-25 characters only")
	private String userName;
	@NotNull
	@Size(min = 4, message = "Please provide Password is 4-12 characters only")
	private String userPassword;
	@NotNull
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_mapping", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<UserRole> userRoles;
	@NotNull
	@DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
	private LocalDateTime crDt;
	@NotNull
	@DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
	private LocalDateTime updDt;

}

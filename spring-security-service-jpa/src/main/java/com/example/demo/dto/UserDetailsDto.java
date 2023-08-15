package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {

	@NotNull
	@Size(min = 2, max = 25, message = "Please provide User Name is 2-25 characters only")
	private String userName;
	@NotNull
	@Size(min = 4, max = 12, message = "Please provide Password is 4-12 characters only")
	private String password;

}

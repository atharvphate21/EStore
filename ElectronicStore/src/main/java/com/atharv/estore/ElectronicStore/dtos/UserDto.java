package com.atharv.estore.ElectronicStore.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
	
	private String userId;
	
	@Size(min = 3, max = 10, message = "Invalid name!!")
	private String name;
	@Email(message = "Invalid user email !!")
	private String email;
	
	@NotBlank(message = "Password is required!!")
	private String password;
	private String gender;
	private String about;
	private String imageName;

}

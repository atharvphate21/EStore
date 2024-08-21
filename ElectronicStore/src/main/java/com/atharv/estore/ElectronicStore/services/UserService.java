package com.atharv.estore.ElectronicStore.services;

import java.util.List;

import com.atharv.estore.ElectronicStore.dtos.UserDto;


public interface UserService {
//	create
	UserDto createUser(UserDto userDto);
//	update
	UserDto updateUser(UserDto userDto, String userId);
//	delete
	void deleteUser(String userId);
//	get all users
	List<UserDto> getAllUser();
//	get single user by id
	UserDto getUserById(String userId);
//	get single user by email
	UserDto getUserByEmail(String userEmail);
//	search user
	List<UserDto> searchUser(String keyword);
//	other user specific features
}

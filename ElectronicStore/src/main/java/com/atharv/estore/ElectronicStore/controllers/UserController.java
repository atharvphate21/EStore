package com.atharv.estore.ElectronicStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atharv.estore.ElectronicStore.dtos.ApiResponseMessage;
import com.atharv.estore.ElectronicStore.dtos.UserDto;
import com.atharv.estore.ElectronicStore.services.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	
//	create
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto userDto1 = userService.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
	}
//	update
	@PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable("userId") String userId,
            @Valid @RequestBody UserDto userDto
    ) {
        UserDto updatedUserDto = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }
	
	
	
//	delete
	@DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        ApiResponseMessage message
                = ApiResponseMessage
                .builder()
                .message("User is deleted Successfully !!")
                .success(true)
                .status(HttpStatus.OK)
                .build();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
	
	
	
//	get all
	
	@GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
	
	
//	get single
	@GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
	
//	get by email
	 @GetMapping("/email/{email}")
	 public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
		 return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
	    }
	
//	search user
	 @GetMapping("/search/{keywords}")
	   public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keywords) {
		 return new ResponseEntity<>(userService.searchUser(keywords), HttpStatus.OK);
	    }
}

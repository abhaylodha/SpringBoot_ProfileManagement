package com.ak.profile_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.profile_management.concepts.User;

@RestController
@CrossOrigin//(origins = "http://localhost:4200/")
public class UsersController {

	@Autowired
	Users users;

	@GetMapping(path = "/users/{id}.json")
	public User getUserById(@PathVariable String id) {
		return Users.getUser(id);
	}

	@GetMapping(path="/users.json")
	public List<User> getAllusers(){
		return Users.getAllUsers();
	}
	
	@PutMapping(path = "/users/{id}.json")
	public ResponseEntity<Void> addUpdateUser(@PathVariable String id, @RequestBody User usr) {
		Users.addUpdateUser(id, usr);
		return ResponseEntity.noContent().build();
	}

}

package com.simplilearn.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.User;
import com.simplilearn.webservice.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		List<User> users = userRepo.findAll();
		return users;
	}
	
	@GetMapping("/users/{id}")
	public User getOneUser(@PathVariable(value = "id") long id) {
		User user = userRepo.findById(id).get();
		return user;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User newUser) {
		User user = userRepo.save(newUser);
		return user;
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") long id, @RequestBody User userObj) {
		User fetchUser = userRepo.findById(id).get();
		fetchUser.setName(userObj.getName());
		User user = userRepo.save(fetchUser);
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(value = "id") long id) {
		User user = userRepo.findById(id).get();
		userRepo.delete(user);
	}
	
}

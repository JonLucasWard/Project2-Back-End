package com.revature.carrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.carrental.dao.UsersDAO;
import com.revature.carrental.model.Users;


@RestController
@RequestMapping("/teame")
public class UsersController {

	@Autowired
	UsersDAO usersDAO;

	/*
	 * SAVE/CREATE A USER
	 */
	
	@PostMapping("/register")
	public Users createUsers(@Valid @RequestBody Users users) {
		users.setUsername(users.getUsername());
		users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
		users.setFirstname(users.getFirstname());
		users.setLastname(users.getLastname());
		users.setEmail(users.getEmail());
		users.setPhonenumber(users.getPhonenumber());
		users.setDriverlicense(users.getDriverlicense());
		users.setRole(users.getRole());
		
		return usersDAO.save(users);
	}
	
	/*
	 * GET ALL USERS
	 */
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		
		return usersDAO.findAll();
	}
	
	/*
	 * GET USER BY ID
	 */
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable(value="id") Long userid){
		Users users = usersDAO.findOne(userid);
		if(users == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(users);
	}
	
	/*
	 *  GET USER BY QUERY
	 */
	
	@GetMapping("/users/query")
	public List<Users> getUsersByQuery(@RequestBody Users users){
		return usersDAO.findByCriteria(users);
	}
	
	/*
	 * UPDATE USERS
	 */
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable(value="id") Long userid, @Valid @RequestBody Users usersDetails){
		
		Users users = usersDAO.findOne(userid);
		if(users == null) {
			return ResponseEntity.notFound().build();
		}
		
		users.setUsername(usersDetails.getUsername());
		users.setPassword(usersDetails.getPassword());
		users.setFirstname(usersDetails.getFirstname());
		users.setLastname(usersDetails.getLastname());
		users.setEmail(usersDetails.getEmail());
		users.setPhonenumber(usersDetails.getPhonenumber());
		users.setDriverlicense(usersDetails.getDriverlicense());
		users.setRole(usersDetails.getRole());
		
		Users updateUsers = usersDAO.save(users);
		
		return ResponseEntity.ok().body(updateUsers);
		
	}
	
	/*
	 * DELETE USERS
	 */
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Users> deleteUsers(@PathVariable(value="id") Long userid){
		
		Users users = usersDAO.findOne(userid);
		
		if(users == null) {
			return ResponseEntity.notFound().build();
		}
		
		usersDAO.delete(users);
		
		return ResponseEntity.ok().build();
		
	}
}

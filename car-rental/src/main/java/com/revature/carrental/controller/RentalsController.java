package com.revature.carrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

import com.revature.carrental.dao.RentalsDAO;
import com.revature.carrental.model.Rentals;
import com.revature.carrental.model.Users;


@RestController
@RequestMapping("/teame/rentals")
public class RentalsController {

	@Autowired
	RentalsDAO rentalsDAO;

	/*
	 * SAVE/CREATE A USER
	 */
	
	@PostMapping("/add")
	public Rentals createrentals(@Valid @RequestBody Rentals rentals) {
		rentals.setTransactionid(rentals.getTransactionid());
		rentals.setUserid(rentals.getUserid());
		rentals.setCarid(rentals.getCarid());
		rentals.setDaterented(rentals.getDaterented());
		rentals.setExpectedreturn(rentals.getExpectedreturn());
		rentals.setDescription(rentals.getDescription());
		rentals.setApproved(rentals.getApproved());
		
		return rentalsDAO.save(rentals);
	}
	
	
	/*
	 * GET ALL RENTALS
	 */
	
	@GetMapping("/all")
	public List<Rentals> getAllrentals(){
		
		return rentalsDAO.findAll();
	}
	
	/*
	 *  GET RENTAL BY QUERY
	 */
	
	@GetMapping("/users/query")
	public List<Rentals> getUsersByQuery(@RequestBody Rentals rentals, Integer x){
		if (x == null) {
			x = 0;
		}
		return rentalsDAO.findByCriteria(rentals, new PageRequest(x,10));
	}
	
	/*
	 * GET RENTAL BY ID
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Rentals> getrentalsById(@PathVariable(value="id") Long rentalid){
		
		Rentals rentals = rentalsDAO.findOne(rentalid);
		
		if(rentals == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(rentals);
		
		
	}
	
	/*
	 * UPDATE RENTALS
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<Rentals> updaterentals(@PathVariable(value="id") Long userid, @Valid @RequestBody Rentals rentalsDetails){
		
		Rentals rentals = rentalsDAO.findOne(userid);
		if(rentals == null) {
			return ResponseEntity.notFound().build();
		}
		
		rentals.setTransactionid(rentalsDetails.getTransactionid());
		rentals.setUserid(rentalsDetails.getUserid());
		rentals.setCarid(rentalsDetails.getCarid());
		rentals.setDaterented(rentalsDetails.getDaterented());
		rentals.setExpectedreturn(rentalsDetails.getExpectedreturn());
		rentals.setDescription(rentalsDetails.getDescription());
		rentals.setApproved(rentalsDetails.getApproved());
		
		Rentals updaterentals = rentalsDAO.save(rentals);
		
		return ResponseEntity.ok().body(updaterentals);
		
	}
	
	/*
	 * DELETE RENTALS
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Rentals> deleterentals(@PathVariable(value="id") Long rentalid){
		
		Rentals rentals = rentalsDAO.findOne(rentalid);
		
		if(rentals == null) {
			return ResponseEntity.notFound().build();
		}
		
		rentalsDAO.delete(rentals);
		
		return ResponseEntity.ok().build();
		
	}
}

package com.revature.carrental.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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


@RestController
@RequestMapping("/teame/rentals")
@CrossOrigin
public class RentalsController {

	@Autowired
	RentalsDAO rentalsDAO;

	/*
	 * SAVE/CREATE A USER
	 */
	
	@PostMapping("/add")
	public ResponseEntity<Rentals> createrentals(@Valid @RequestBody Rentals rentals) {
		rentals.setTransactionid(rentals.getTransactionid());
		rentals.setUserid(rentals.getUserid());
		rentals.setCarid(rentals.getCarid());
		// make model of all current rentals for that car
		ArrayList<Rentals> y = rentalsDAO.findAll(rentals.getCarid());

		// if start is before an end AND after the start of another rentals. return invalid
		Date inQStart = rentals.getDaterented();
		Date inQEnd = rentals.getExpectedreturn();
		Date listEnd;
		Date listStart;
		for (int x = 0; x < y.size(); x++) {
			listEnd = y.get(x).getExpectedreturn();
			listStart = y.get(x).getDaterented();
			// we now have start and end of current list, and start/end of dates of request
			if( (inQStart.compareTo(listStart) < 0 && inQStart.compareTo(listEnd) <= 0) 
					|| 
				(inQStart.compareTo(listStart) > 0 && inQStart.compareTo(listEnd) >= 0)) {
					// start is before other starts, or after || = other ends
				} else { return ResponseEntity.badRequest().build(); }
				if( (inQEnd.compareTo(listStart) <= 0 && inQEnd.compareTo(listEnd) < 0) 
					|| 
				(inQEnd.compareTo(listStart) >= 0 && inQEnd.compareTo(listEnd) > 0)) {
				// end is before || = other starts, or after other ends
			} else { return ResponseEntity.badRequest().build(); }}
		//if it didn't end early, rental dates are valid and may be accepted
		rentals.setDaterented(rentals.getDaterented());
		rentals.setExpectedreturn(rentals.getExpectedreturn());
		//no errors from the for loop, dates may be set
		rentals.setDescription(rentals.getDescription());
		rentals.setApproved(rentals.getApproved());
		
		rentalsDAO.save(rentals);
		return ResponseEntity.ok().body(rentals);
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
	
	@GetMapping("/query")
	public List<Rentals> getUsersByQuery(@RequestBody Rentals rentals, Integer x, Integer y, Integer z){
		if (x == null) {
			x = 0;
		}
		return rentalsDAO.findByCriteria(rentals, new PageRequest(x,10), y, z);
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
	public ResponseEntity<Rentals> updaterentals(@PathVariable(value="id") Long transactionid, @Valid @RequestBody Rentals rentalsDetails){
		
		Rentals rentals = rentalsDAO.findOne(transactionid);
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
		Date end;
			end = rentals.getExpectedreturn();
			Date now = new java.util.Date();
			if(now.compareTo(end) > 0) {
				return ResponseEntity.badRequest().build();
			}
			rentalsDAO.delete(rentals);
			return ResponseEntity.ok().build();
	}
}

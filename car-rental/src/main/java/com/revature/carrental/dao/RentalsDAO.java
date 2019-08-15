package com.revature.carrental.dao;

import com.revature.carrental.model.Rentals;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.carrental.repository.RentalsRepository;

@Service
public class RentalsDAO  {
	
	@Autowired
	RentalsRepository rentalsRepository;
	
	/*
	 * SAVE rentals
	 */
	
	public Rentals save(Rentals rentals) {
		return rentalsRepository.save(rentals);
		
	}
	
	
	/*
	 * SEARCH ALL rentals
	 */
	public List<Rentals> findAll(){
		return rentalsRepository.findAll();
	}
	
	
	/*
	 * GET A RENTAL BY ID
	 */
	
	public Rentals findOne(Long rentalid) {
		return rentalsRepository.findOne(rentalid);
	}
	
	/*
	 * DELETE rentals
	 */
	
	public void delete(Rentals rentals) {
		rentalsRepository.delete(rentals);
	}


}
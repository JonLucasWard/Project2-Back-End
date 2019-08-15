package com.revature.carrental.repository;

import com.revature.carrental.model.Rentals;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rentals, Long >{

	
}

package com.revature.carrental.repository;

import com.revature.carrental.model.Billings;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingsRepository extends JpaRepository<Billings, Long >{
	
}
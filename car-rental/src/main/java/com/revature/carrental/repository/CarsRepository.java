package com.revature.carrental.repository;

import com.revature.carrental.model.Car;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car>{
	
}
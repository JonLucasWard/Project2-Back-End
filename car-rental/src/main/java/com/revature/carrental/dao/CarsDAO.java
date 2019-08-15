package com.revature.carrental.dao;

import com.revature.carrental.model.Car;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.carrental.repository.CarsRepository;

@Service
public class CarsDAO  {
	
	@Autowired
	CarsRepository carsRepository;
	
	/*
	 * SAVE CARS
	 */
	
	public Car save(Car cars) {
		return carsRepository.save(cars);
		
	}
	
	
	/*
	 * SEARCH ALL USERS
	 */
	public List<Car> findAll(){
		return carsRepository.findAll();
	}
	
	
	/*
	 * GET A CAR BY ID
	 */
	
	public Car findOne(Long carid) {
		return carsRepository.findOne(carid);
	}
	
	/*
	 * DELETE CARS
	 */
	
	public void delete(Car cars) {
		carsRepository.delete(cars);
	}


}
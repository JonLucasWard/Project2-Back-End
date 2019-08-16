package com.revature.carrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.carrental.dao.CarsDAO;
import com.revature.carrental.model.Car;


@RestController
@RequestMapping("/teame/cars")
public class CarsController {

	@Autowired
	CarsDAO carsDAO;

	/*
	 * SAVE/CREATE A Car
	 */
	
	@PostMapping("/add")
	public Car createCars(@Valid @RequestBody Car cars) {
		cars.setBrand(cars.getBrand());
		cars.setModel(cars.getModel());
		cars.setMakeyear(cars.getMakeyear());
		cars.setOccupancy(cars.getOccupancy());
		cars.setTransmission(cars.getTransmission());
		cars.setMileage(cars.getMileage());
		cars.setColor(cars.getColor());
		cars.setAc(cars.getAc());
		cars.setStatusid(cars.getStatusid());
		cars.setRate(cars.getRate());
		cars.setTypeid(cars.getTypeid());
		
		return carsDAO.save(cars);
	}
	
	
	/*
	 * GET ALL CARS
	 */
	
	@GetMapping("/all")
	public List<Car> getAllcars(){
		
		return carsDAO.findAll();
	}
	
	/*
	 * GET CAR BY ID
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> getcarsById(@PathVariable(value="id") Long carid){
		
		Car cars = carsDAO.findOne(carid);
		
		if(cars == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(cars);
		
		
	}
	
	/*
	 * UPDATE CARS
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<Car> updatecars(@PathVariable(value="id") Long userid, @Valid @RequestBody Car carsDetails){
		
		Car cars = carsDAO.findOne(userid);
		if(cars == null) {
			return ResponseEntity.notFound().build();
		}
		
		cars.setBrand(carsDetails.getBrand());
		cars.setModel(carsDetails.getModel());
		cars.setMakeyear(carsDetails.getMakeyear());
		cars.setOccupancy(carsDetails.getOccupancy());
		cars.setTransmission(carsDetails.getTransmission());
		cars.setMileage(carsDetails.getMileage());
		cars.setColor(carsDetails.getColor());
		cars.setAc(carsDetails.getAc());
		cars.setStatusid(carsDetails.getStatusid());
		cars.setRate(carsDetails.getRate());
		cars.setTypeid(carsDetails.getTypeid());
		
		Car updatecars = carsDAO.save(cars);
		
		return ResponseEntity.ok().body(updatecars);
		
	}
	
	/*
	 * DELETE cars
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Car> deletecars(@PathVariable(value="id") Long carid){
		
		Car cars = carsDAO.findOne(carid);
		
		if(cars == null) {
			return ResponseEntity.notFound().build();
		}
		
		carsDAO.delete(cars);
		
		return ResponseEntity.ok().build();
		
	}
}
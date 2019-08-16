package com.revature.carrental.dao;

import com.revature.carrental.model.Car;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
	 * SEARCH ALL CARS
	 */
	public List<Car> findAll() {
		return carsRepository.findAll(new Specification<Car>() {
			@Override
			public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		});
	}
	
	/*
	 * SEARCH ALL CARS BY QUERY
	 */
	public List<Car> findByCriteria(Car cars){
		return carsRepository.findAll(new Specification<Car>() {
            @Override
        	public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(cars.getCarid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("carid"), cars.getCarid())));
                }
                if(cars.getBrand()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("brand"), "%"+cars.getBrand()+"%")));
                }
                if(cars.getColor()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("color"), "%"+cars.getColor()+"%")));
                }
                if(cars.getMakeyear()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("makeyear"), "%"+cars.getMakeyear()+"%")));
                }
                if(cars.getModel()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("model"), "%"+cars.getModel()+"%")));
                }
                if(cars.getTransmission()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("transmission"), "%"+cars.getTransmission()+"%")));
                }
                if(cars.getMileage()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("mileage"), cars.getMileage())));
                }
                if(cars.getOccupancy()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("occupancy"), cars.getOccupancy())));
                }
                if(cars.getRate()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("rate"), cars.getRate())));
                }
                if(cars.getStatusid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("statusid"), cars.getStatusid())));
                }
                if(cars.getTypeid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("typeid"), cars.getTypeid())));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
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
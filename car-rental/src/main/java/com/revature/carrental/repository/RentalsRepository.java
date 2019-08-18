package com.revature.carrental.repository;

import com.revature.carrental.model.Rentals;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@Repository
public interface RentalsRepository extends JpaRepository<Rentals, Long>, JpaSpecificationExecutor<Rentals>{

	List<Rentals> findAll();
	ArrayList<Rentals> findAllBycarid(Long carid);
}

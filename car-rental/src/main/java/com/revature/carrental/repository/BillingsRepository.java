package com.revature.carrental.repository;

import com.revature.carrental.model.Billings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@Repository
public interface BillingsRepository extends JpaRepository<Billings, Long>, JpaSpecificationExecutor<Billings>{
	List<Billings> findAll();
}
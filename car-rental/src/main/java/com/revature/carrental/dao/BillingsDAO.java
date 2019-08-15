package com.revature.carrental.dao;

import com.revature.carrental.model.Billings;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.carrental.repository.BillingsRepository;

@Service
public class BillingsDAO  {
	
	@Autowired
	BillingsRepository billingsRepository;
	
	/*
	 * SAVE BILLINGS
	 */
	
	public Billings save(Billings billings) {
		return billingsRepository.save(billings);
		
	}
	
	
	/*
	 * SEARCH ALL BILLINGS
	 */
	public List<Billings> findAll(){
		return billingsRepository.findAll();
	}
	
	
	/*
	 * GET A BILL BY ID
	 */
	
	public Billings findOne(Long billingid) {
		return billingsRepository.findOne(billingid);
	}
	
	/*
	 * DELETE BILLINGS
	 */
	
	public void delete(Billings billings) {
		billingsRepository.delete(billings);
	}


}
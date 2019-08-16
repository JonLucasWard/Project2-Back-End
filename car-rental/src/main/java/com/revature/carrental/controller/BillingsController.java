package com.revature.carrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.carrental.dao.BillingsDAO;
import com.revature.carrental.model.Billings;


@RestController
@RequestMapping("/teame/billings")
public class BillingsController {

	@Autowired
	BillingsDAO billingsDAO;

	/*
	 * SAVE/CREATE A USER
	 */
	
	@PostMapping("/add")
	public Billings createbillings(@Valid @RequestBody Billings billings) {
		billings.setBillingid(billings.getBillingid());
		billings.setUserid(billings.getUserid());
		billings.setTransactionid(billings.getTransactionid());
		billings.setCardno(billings.getCardno());
		billings.setExpdate(billings.getExpdate());
		billings.setCvv(billings.getCvv());
		billings.setAmount(billings.getAmount());
		
		return billingsDAO.save(billings);
	}
	
	
	/*
	 * GET ALL billings
	 */
	
	@GetMapping("/all")
	public List<Billings> getAllbillings(){
		
		return billingsDAO.findAll();
	}
	
	/*
	 *  GET USER BY QUERY
	 */
	
	@GetMapping("/users/query")
	public List<Billings> getUsersByQuery(@RequestBody Billings bills, Integer x){
		if (x == null) {
			x = 0;
		}
		return billingsDAO.findByCriteria(bills, new PageRequest(x, 10));
	}
	
	/*
	 * GET BILL BY ID
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Billings> getbillingsById(@PathVariable(value="id") Long billingid){
		
		Billings billings = billingsDAO.findOne(billingid);
		
		if(billings == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(billings);
		
	}
	
	/*
	 * UPDATE billings
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<Billings> updatebillings(@PathVariable(value="id") Long billingid, @Valid @RequestBody Billings billingsDetails){
		
		Billings billings = billingsDAO.findOne(billingid);
		if(billings == null) {
			return ResponseEntity.notFound().build();
		}
		
		billings.setBillingid(billingsDetails.getBillingid());
		billings.setUserid(billingsDetails.getUserid());
		billings.setTransactionid(billingsDetails.getTransactionid());
		billings.setCardno(billingsDetails.getCardno());
		billings.setExpdate(billingsDetails.getExpdate());
		billings.setCvv(billingsDetails.getCvv());
		billings.setAmount(billingsDetails.getAmount());
		
		Billings updatebillings = billingsDAO.save(billings);
		
		return ResponseEntity.ok().body(updatebillings);
		
	}
	
	/*
	 * DELETE billings
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Billings> deletebillings(@PathVariable(value="id") Long userid){
		
		Billings billings = billingsDAO.findOne(userid);
		
		if(billings == null) {
			return ResponseEntity.notFound().build();
		}
		
		billingsDAO.delete(billings);
		
		return ResponseEntity.ok().build();
		
	}
}

package com.revature.carrental.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="rentals")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin
public class Rentals {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long transactionid;
	
	@Column(nullable = false)
	private Long userid;
	
	@Column(nullable = false)
	private Long carid;
	
	@Column(nullable = false)
	private Date daterented;
	
	@Column(nullable = false)
	private Date expectedreturn;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Boolean approved;
	
	public Long getTransactionid() {
		return transactionid;
	}


	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public Long getCarid() {
		return carid;
	}


	public void setCarid(Long carid) {
		this.carid = carid;
	}


	public Date getDaterented() {
		return daterented;
	}


	public void setDaterented(Date daterented) {
		this.daterented = daterented;
	}


	public Date getExpectedreturn() {
		return expectedreturn;
	}


	public void setExpectedreturn(Date expectedreturn) {
		this.expectedreturn = expectedreturn;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getApproved() {
		return approved;
	}


	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	

	@Override
	public String toString() {
		return "Rentals [transactionid=" + transactionid + ", userid=" + userid + ", carid=" + carid + ", daterented="
				+ daterented + ", expectedreturn=" + expectedreturn + ", description=" + description + ", approved=" + approved + "]";
		}
	}

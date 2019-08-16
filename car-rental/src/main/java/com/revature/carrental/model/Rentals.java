package com.revature.carrental.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="rentals")
@EntityListeners(AuditingEntityListener.class)
public class Rentals {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long transactionid;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Users userid;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Car carid;
	
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


	public Users getUserid() {
		return userid;
	}


	public void setUserid(Users userid) {
		this.userid = userid;
	}


	public Car getCarid() {
		return carid;
	}


	public void setCarid(Car carid) {
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

package com.revature.carrental.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="rentals")
@EntityListeners(AuditingEntityListener.class)
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
	private String daterented;
	
	@Column(nullable = false)
	private String expectedreturn;
	
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


	public String getDaterented() {
		return daterented;
	}


	public void setDaterented(String daterented) {
		this.daterented = daterented;
	}


	public String getExpectedreturn() {
		return expectedreturn;
	}


	public void setExpectedreturn(String expectedreturn) {
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

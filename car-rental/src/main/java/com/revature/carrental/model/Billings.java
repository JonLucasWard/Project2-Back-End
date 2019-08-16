package com.revature.carrental.model;

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
@Table(name="billing")
@EntityListeners(AuditingEntityListener.class)
public class Billings {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long billingid;
	
	public Long getBillingid() {
		return billingid;
	}

	public void setBillingid(Long billingid) {
		this.billingid = billingid;
	}

	public Users getUserid() {
		return userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}

	public Rentals getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(Rentals transactionid) {
		this.transactionid = transactionid;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public Long getCvv() {
		return cvv;
	}

	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@ManyToOne
	@JoinColumn(nullable = false)
	private Users userid;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Rentals transactionid;
	
	@Column(nullable = false)
	private String nameoncard;
	
	@Column(nullable = false)
	private String cardno;
	
	@Column(nullable = false)
	private String expdate;
	
	@Column(nullable = false)
	private Long cvv;
	
	@Column(nullable = false)
	private Long amount;

	@Override
	public String toString() {
		return "Billings [billingid=" + billingid + ", userid=" + userid + ", NameOnCard=" + nameoncard + ", cardno="
				+ cardno + ", expdate=" + expdate + ", cvv=" + cvv + ", amount=" + amount + "]";
	}

	
}

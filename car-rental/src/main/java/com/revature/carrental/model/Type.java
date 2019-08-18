package com.revature.carrental.model;

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
@Table(name="type")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin
public class Type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer typeid;
	
	@Column(nullable = false)
	private String type;
	
	public Integer gettypeid() {
		return typeid;
	}

	public void settypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getRole() {
		return type;
	}

	public void setRole(String type) {
		this.type = type;
	}

}
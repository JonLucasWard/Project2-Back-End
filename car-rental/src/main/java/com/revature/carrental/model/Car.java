package com.revature.carrental.model;

import java.util.Collection;
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
@Table(name="cars")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long carid;
	
	@Column(nullable = false)
	private String brand;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private Date makeyear;
	
	@Column(nullable = false)
	private Integer occupancy;
	
	@Column(nullable = false)
	private String transmission;
	
	@Column(nullable = false)
	private Long mileage;
	
	@Column(nullable = false)
	private String color;
	
	@Column(nullable = false)
	private Boolean ac;
	
	@Column(nullable = false)
	private Integer statusid;
	
	@Column(nullable = false)
	private Long rate;
	
	@Column(nullable = false)
	private Integer typeid;
	
	public Long getCarid() {
		return carid;
	}

	public void setCarid(Long carid) {
		this.carid = carid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getMakeyear() {
		return makeyear;
	}

	public void setMakeyear(Date makeyear) {
		this.makeyear = makeyear;
	}

	public Integer getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(Integer occupancy) {
		this.occupancy = occupancy;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public Long getMileage() {
		return mileage;
	}

	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getAc() {
		return ac;
	}

	public void setAc(Boolean ac) {
		this.ac = ac;
	}

	public Integer getStatusid() {
		return statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	@Override
	public String toString() {
		return "Cars [carid=" + carid + ", brand=" + brand + ", model=" + model + ", makeyear="
				+ makeyear + ", occupancy=" + occupancy + ", transmission=" + transmission + ", mileage=" + mileage
				+ ", color=" + color + ", ac=" + ac + ", statusid=" + statusid + ", rate=" + rate + " typeid=" + typeid + "]";
	}

	
}

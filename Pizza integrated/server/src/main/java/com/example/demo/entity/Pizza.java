package com.example.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Pizza")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pizza{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,updatable=false)
	public int id;
	public String name;
	public String type;
	public String description;
	public Double price;
	public String url;
	public Double pizzaCostAfterCoupon;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pizza_id",referencedColumnName="id")
	public List<Coupan> coupan;  
	
	public Pizza() {}
	
	public Pizza(String name,Double price,String description,String url,String type,Double pizzaCostAfterCoupon) {
		this.name=name;
		this.price=price;
		this.type=type;
		this.description=description;
		this.url=url;

		this.pizzaCostAfterCoupon=pizzaCostAfterCoupon;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return  name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price=price;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url=url;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	public String gettype() {
		return type;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public List<Coupan> getCoupon() {
		return coupan;
	}
	
	public void setCoupon(List<Coupan> coupon) {
		this.coupan=coupon;
	}
	
	public Double getpizzaCostAfterCoupon() {
		return pizzaCostAfterCoupon;
	}
	
	public void setpizzaCostAfterCoupon(Double pizzaCostAfterCoupon) {
		this.pizzaCostAfterCoupon=pizzaCostAfterCoupon;
	}
}

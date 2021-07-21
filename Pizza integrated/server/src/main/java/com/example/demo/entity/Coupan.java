package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Coupan")
public class Coupan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	@GenericGenerator(name = "seq", strategy="increment")
	private int coupanid;
	private String coupanName;
	private int coupanType;
	private String coupaanDescription;
	private int coupanPizzaid;
	public int getCoupanid() {
		return coupanid;
	}
	public void setCoupanid(int coupanId) {
		this.coupanid = coupanId;
	}
	public String getCoupanName() {
		return coupanName;
	}
	public void setCoupanName(String coupanName) {
		this.coupanName = coupanName;
	}
	public int getCoupanType() {
		return coupanType;
	}
	public void setCoupanType(int coupanType) {
		this.coupanType = coupanType;
	}
	public String getCoupaanDescription() {
		return coupaanDescription;
	}
	public void setCoupaanDescription(String coupaanDescription) {
		this.coupaanDescription = coupaanDescription;
	}
	public int getCoupanPizzaid() {
		return coupanPizzaid;
	}
	public void setCoupanPizzaid(int coupanPizzaid) {
		this.coupanPizzaid = coupanPizzaid;
	}
	
}

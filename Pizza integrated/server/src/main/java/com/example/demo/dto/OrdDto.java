package com.example.demo.dto;

import com.example.demo.entity.Order;

public class OrdDto {

	private Order ord;

	public Order getOrd() {
		return ord;
	}

	public void setOrd(Order ord) {
		this.ord = ord;
	}

	public OrdDto(Order ord) {
		super();
		this.ord = ord;
	}

	public OrdDto() {
		super();
		
	}
	
}

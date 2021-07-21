package com.example.demo.dto;

import com.example.demo.entity.PizzaOrder;

public class PizzaOrderDto {

	private PizzaOrder pord;

	public PizzaOrder getPord() {
		return pord;
	}

	public void setPord(PizzaOrder pord) {
		this.pord = pord;
	}

	public PizzaOrderDto(PizzaOrder pord) {
		super();
		this.pord = pord;
	}

	public PizzaOrderDto() {
		super();

	}

	
}

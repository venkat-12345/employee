package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrdDto;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService ser;
	
	@PostMapping("/addOrder")
	public Order  addOrder(@RequestBody OrdDto ord){
		return ser.addOrder(ord.getOrd());
	}
}

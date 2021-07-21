package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/order/add")
	public ResponseEntity<Order> addOrder(@RequestBody OrdDto ord){
		return new ResponseEntity<>(ser.addOrder(ord.getOrd()),HttpStatus.CREATED);
	}
	@GetMapping("/order/viewAll")
	public ResponseEntity<List<Order>> viewOrder(){
	return new ResponseEntity<>(ser.viewOrder(),HttpStatus.CREATED);
	}
}

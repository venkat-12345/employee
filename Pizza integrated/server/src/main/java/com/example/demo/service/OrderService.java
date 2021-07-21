package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository rep;
	
	public Order addOrder(Order ord) {
		return rep.save(ord);
	}

	public List<Order> viewOrder() {

		return rep.findAll();
	}
}

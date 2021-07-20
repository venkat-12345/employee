package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PizzaOrderDto;
import com.example.demo.entity.PizzaOrder;
import com.example.demo.service.PizzaOrderService;

@RestController
public class PizzaOrderController {

	@Autowired
	private PizzaOrderService ser;
	
	@PostMapping("/placeOrder")
	public PizzaOrder addOrder(@RequestBody PizzaOrderDto pord) {
		return ser.bookPizzaOrder(pord.getPord());
	}
	@PostMapping("/updateOrder")
	public PizzaOrder updateOrder(@RequestBody PizzaOrderDto pord) {
		return ser.updatePizzaOrder(pord.getPord());
	}
	@GetMapping("/viewAll")
	public List<PizzaOrder> getOrders() {
		return ser.viewOrderList();
	}
	@GetMapping("/calculateTotal")
	public List<PizzaOrder> calculateTotal() {
		return ser.calculateTotal();
	}
	@GetMapping("/viewbyDate/{str}")
	public List<PizzaOrder> getOrdersbyDate(@PathVariable String str ) {
		var date=LocalDate.parse(str);
		return ser.viewOrderList(date);
	}
	
}

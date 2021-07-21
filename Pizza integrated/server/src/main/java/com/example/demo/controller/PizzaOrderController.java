package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PostMapping("/pizzaOrder/placeOrder")
	 @PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<PizzaOrder> addOrder(@RequestBody PizzaOrderDto pord) {
		return new ResponseEntity<>(ser.bookPizzaOrder(pord.getPord()),HttpStatus.CREATED);
	}
	@PostMapping("/pizzaOrder/updateOrder")
	 @PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<PizzaOrder> updateOrder(@RequestBody PizzaOrderDto pord) {
		return new ResponseEntity<>(ser.updatePizzaOrder(pord.getPord()),HttpStatus.OK);
	}
	@GetMapping("/pizzaOrder/viewAll")
	 @PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<List<PizzaOrder>> getOrders() {
		return new ResponseEntity<>(ser.viewOrderList(),HttpStatus.OK);
	}
	@GetMapping("/pizzaOrder/calculateTotal")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<PizzaOrder>> calculateTotal() {
		return new ResponseEntity<>(ser.calculateTotal(),HttpStatus.OK);
	}
	@GetMapping("/pizzaOrder/viewbyDate/{str}")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<PizzaOrder>> getOrdersbyDate(@PathVariable String str ) {
		var date=LocalDate.parse(str);
		return new ResponseEntity<>(ser.viewOrderList(date),HttpStatus.OK);
	}
	
}

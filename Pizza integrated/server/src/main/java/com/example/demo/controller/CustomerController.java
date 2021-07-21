package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;



@RestController
@RequestMapping("/rest/customer")
public class CustomerController {
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>>getAllCustomer(){
		List<Customer> customer = customerService.findAllCustomers();
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto customer){
		Customer newCustomer = customerService.addCustomer(customer.getCustomer());
		return new ResponseEntity<>(newCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDto customer){
		customerService.updateCustomer(customer.getCustomer());
		return new ResponseEntity<>(customer.getCustomer(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
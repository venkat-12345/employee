package com.example.demo.service;


import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepo;



@Service
@Transactional
public class CustomerService {
	private final CustomerRepo customerRepo;
	
	
	@Autowired
	public CustomerService(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
		
	}
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public List<Customer> findAllCustomers(){
		return customerRepo.findAll();
	}
	
	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);
	}
		
	public void updateCustomer(Customer customer) {
		Customer newcustomer=customerRepo.getById(customer.getId());
		newcustomer.setName(customer.name);
		newcustomer.setEmail(customer.email);
		newcustomer.setPhone(customer.phone);
		newcustomer.setAddress( customer.address);
		
	}
	
	
	
	
	
}
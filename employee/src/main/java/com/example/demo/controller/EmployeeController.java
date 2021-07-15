package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService ser;
	
	@GetMapping("/getallemp")
	public List<Employee> getemp(){
		return ser.viewall();
	}
	
	@PostMapping("/addemp")
	public Employee addemp(@RequestBody Employee emp) {
		return ser.addEmployee(emp);
	}
}

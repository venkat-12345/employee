package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository rep;
	
	public Employee addEmployee(Employee emp) {
		return rep.save(emp);
	}
	public List<Employee> viewall(){
		return rep.findAll();
	}
}

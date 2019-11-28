package com.samu.employeeRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samu.employeeRegistration.model.Employee;
import com.samu.employeeRegistration.repository.EmployeeRepository;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;

	@PostMapping(value = "/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees(){
		return repository.findAllOrderByFirstNameAsc();
	}

	@DeleteMapping(value="/remove")
	public Employee removeEmployee(@RequestBody Employee employee) {
		repository.delete(employee);
		return employee;
	}


}

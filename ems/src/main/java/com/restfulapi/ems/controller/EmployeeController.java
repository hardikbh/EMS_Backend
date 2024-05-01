package com.restfulapi.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfulapi.ems.model.Employee;
import com.restfulapi.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
     private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
     // build create employee rest api
	
	//  this postmapping pass json object that we need to bind as java object i.e. employee object
	// we use @RequestBody annotation for this 
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		//System.out.println(employee.getfirstName());
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	// build get all the employees rest api
	
	@GetMapping
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	// build get employee by id
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id")long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployee(employeeId),HttpStatus.OK);
	}
	//build update employee rest api
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,
			@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId),HttpStatus.OK);
	}
	
	//  build delete rest api
	@DeleteMapping("{id}")
	 public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId)
	 {
		 employeeService.deleteEmployee(employeeId);
		 return new ResponseEntity<String>("**Employee is deleted**",HttpStatus.OK);
	 }
	
	
}

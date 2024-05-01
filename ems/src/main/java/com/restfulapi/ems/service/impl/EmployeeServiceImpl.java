package com.restfulapi.ems.service.impl;

import java.util.List;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfulapi.ems.exception.ResourceNotFoundException;
import com.restfulapi.ems.model.Employee;
import com.restfulapi.ems.repository.EmployeeRepository;
import com.restfulapi.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	//use Setter based dependency injection when uses optional parameters
	//use Constructor based dependency injection when uses mandatory parameter 
	
	private EmployeeRepository employeeRepository;
	// here we do not need to use Autowired annotation staring Spring 4.3 if a class which is configured as a Spring bean, has only one constuctor , the autowired annotation can be omitted and Spring will use that constructor and inject all necessary dependencies
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(long id) {
	/*	Optional<Employee> employee = employeeRepository.findById(id);
	     if(employee.isPresent())
	     {
	    	 return employee.get();
	     }
	     else
	     {
	    	 throw new ResourceNotFoundException("Employee","Id",id);
	     }
	     */
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		// we need to check whether the employee is present or not
		Employee exsistingEmployee = employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee","Id",id));
		exsistingEmployee.setFirstName(employee.getFirstName());
		exsistingEmployee.setLastName(employee.getLastName());
		exsistingEmployee.setEmail(employee.getEmail());
		return employeeRepository.save(exsistingEmployee);
		
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee","Id",id));
		
		employeeRepository.deleteById(id);
		
	}
	
	
	
	

}

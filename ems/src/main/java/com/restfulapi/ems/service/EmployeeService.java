package com.restfulapi.ems.service;

import java.util.List;

import com.restfulapi.ems.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployee(long id);
	Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);
}

package com.restfulapi.ems.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.restfulapi.ems.model.Employee;

// @Repository we do not need to use this annotation as we already uses extends JpaRepository it internally uses it

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
   
}

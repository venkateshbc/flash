package com.samu.employeeRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samu.employeeRegistration.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> 
{
    @Query("From Employee Order by firstname ASC")
    List<Employee> findAllOrderByFirstNameAsc();
	
}

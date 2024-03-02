package com.data.service;

import java.util.List;

import com.data.entity.Employee;

public interface EmployeeService {
	String addEmployee(Employee employee);
	Employee getEmployeeById(Integer id);
	List<Employee> getAllEmployees(Long length);
	Employee updateEmployee(Employee employee,Integer id);
    boolean deleteEmployeeById(Integer id);
   // void deleteEmployee(Integer id);
	

}

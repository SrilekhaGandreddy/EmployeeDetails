package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}

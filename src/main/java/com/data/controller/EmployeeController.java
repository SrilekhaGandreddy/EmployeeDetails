package com.data.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.Employee;
import com.data.service.EmployeeService;

@RequestMapping("/Employee")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;

	// http/8080/Employee/add
	@PostMapping("/add")
	public ResponseEntity<String> saveEmployeeToDB(@RequestBody Employee emp) {
		String Empsaved = empservice.addEmployee(emp);
		return new ResponseEntity<>(Empsaved, HttpStatus.CREATED);
	}

	// http/8080/Employee/2
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		Employee gotEmp = empservice.getEmployeeById(id);
		return new ResponseEntity<>(gotEmp, HttpStatus.OK);
	}

	// http/8080/Employee/all
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmp(@RequestParam(name="length",required=false) Long length) {
		List<Employee> emplist = empservice.getAllEmployees(length);
		if(length==null) {
		return new ResponseEntity<>(emplist.stream().limit(emplist.size()).collect(Collectors.toList()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(emplist.stream().limit(length).collect(Collectors.toList()), HttpStatus.OK);
		}
	}
	

	// http/8080/Employee/update/4   and body
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmploye(@RequestBody Employee emp,@PathVariable Integer id){
		Employee updateEmployee = empservice.updateEmployee(emp,id);
		return new ResponseEntity<>(updateEmployee,HttpStatus.ACCEPTED);
	}
	
	// http/8080/Employee/delete/4 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable Integer id)
	{
		boolean isDeleted= empservice.deleteEmployeeById(id);
		String msg=" ";
		if(isDeleted)
		{
			msg="Employee is deleted";
		}
		else {
			msg="Employee is not deleted";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}

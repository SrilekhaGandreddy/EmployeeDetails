package com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entity.Employee;
import com.data.exception.EmployeeException;
import com.data.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public String addEmployee(Employee employee) {
		Employee empObj = employeeRepo.save(employee);
		if (empObj.getId() != null)
			return "Employee created successfully";
		else
			return "Not created! try again";
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee can not found !!!"));

	}

	@Override
	public List<Employee> getAllEmployees(Long length) {
		return employeeRepo.findAll();

	}

//	@Override
//	public Employee updateEmployee(Employee employee,Integer id) {
//		Employee existingEmp=employeeRepo.findById(id).get();
//		existingEmp.setName(employee.getName());
//		existingEmp.setYear(employee.getYear());
//		existingEmp.setGender(employee.getGender());
//		return employeeRepo.save(existingEmp) ;
//	}

	@Override
	public Employee updateEmployee(Employee emp, Integer id) {
		Employee existingEmployee = employeeRepo.findById(id).get();
		existingEmployee.setName(emp.getName());
		existingEmployee.setGender(emp.getGender());
		existingEmployee.setYear(emp.getYear());
		return employeeRepo.save(existingEmployee);
	}

//	@Override
//	public void deleteEmployee(Integer id) {
//		 employeeRepo.deleteById(id);;
//		
//	}
	
	@Override
	public boolean deleteEmployeeById(Integer id) {
		boolean status=false;
		Employee empRecord = employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeException("Employee record not found in the DB with ID:"+id));
			if(empRecord != null)
			{
				try {
					employeeRepo.deleteById(id);
					status=true;
				}
				catch(EmployeeException e)
				{
					System.out.println(e);
				}
			}
		return status;
		}

}

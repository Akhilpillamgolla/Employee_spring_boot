package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	public Optional<Employee> getEmployeeId(int id){
		return employeeRepository.findById(id);
	}
	
	
	public List<Employee> getEmployeeByName(String name){
		return employeeRepository.findByName(name);
	}
	
	public List<Employee> getEmployeesBySalary(Double salary){
		return employeeRepository.findBySalary(salary);
	}
	
	public Employee updateEmployee( Employee updatedEmployee) {
		Optional<Employee> optionalEmployee=employeeRepository.findById(updatedEmployee.getId());
		if(optionalEmployee.isPresent()) {
			Employee employee=optionalEmployee.get();
			
		   if(employee.getName()!=null) {
			  employee.setName(updatedEmployee.getName());
		   }
			
			employee.setName(updatedEmployee.getName());
			employee.setEmail_id(updatedEmployee.getEmail_id());
			employee.setDepartment_id(updatedEmployee.getDepartment_id());
			employee.setDepartmet_name(updatedEmployee.getDepartmet_name());
			employee.setSalary(updatedEmployee.getSalary());
			employee.setDesignation(updatedEmployee.getDesignation());
			return employeeRepository.save(employee);

			
		}
		else {
			return null;
		}
	}
	
	
	public void deleteEmployee(int id){
		employeeRepository.deleteById(id);
	}
	
}

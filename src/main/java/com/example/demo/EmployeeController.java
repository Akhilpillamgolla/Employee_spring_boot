package com.example.demo;

import java.util.List;
import java.util.Optional;

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



@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}

	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee createdEmployee=employeeService.createEmployee(employee);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable("id") int id ){
		Optional<Employee> employee=employeeService.getEmployeeId(id);
		if(employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/getEmployeeByName/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name){
		List<Employee> employee=employeeService.getEmployeeByName(name);
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
	
	@GetMapping("/getEmployeeBySalary/{salary}")
	public ResponseEntity<List<Employee>> getEmployeeBySalary(@PathVariable("salary") Double salary){
		List<Employee> employees=employeeService.getEmployeesBySalary(salary);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee( @RequestBody Employee employee){
		Employee updatedEmployee=employeeService.updateEmployee( employee);
		
		
		if (updatedEmployee !=null) {
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id){
		
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
	}
	
}

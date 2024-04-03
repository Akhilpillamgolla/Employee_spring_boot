package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeApplication3ApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;
	
	private EmployeeService employeeService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		employeeService = new EmployeeService(employeeRepository);
	}
	
	
	@Test
	public void testcreateEmployee() {
		Employee employee = new Employee();
		employee.setId(4);		
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		
		Employee createdEmployee = employeeService.createEmployee(employee);
		
		assertEquals(employee.getId(), createdEmployee.getId());
	}
	
	
	
	@Test
	public void getEmployeeId() {
		int id = 4;
		Employee employee = new Employee();
		
		employee.setId(id);
		
		when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
		
		
		Optional<Employee> retrivedEmployee = employeeService.getEmployeeId(id);
		
		assertEquals(employee.getId(),retrivedEmployee.get().getId());
		
		
	}
	
	
	@Test
	public void NagativeEmployeeId() {
		int id = 4;
		Employee employee = new Employee();
		
		employee.setId(id);
		
		when(employeeRepository.findById(id)).thenReturn(Optional.empty());
		
		
		Optional<Employee> retrivedEmployee = employeeService.getEmployeeId(id);
		
        assertTrue(retrivedEmployee.isEmpty());
	}
	
	
	@Test
	public void getEmployeeByNameTest() {
		String name ="prasanth";
		
		Employee employee1 = new Employee();
		employee1.setName(name);
		
		Employee employee2 = new Employee();
		employee2.setName(name);
		
		List<Employee> ListOfEmployees = Arrays.asList(employee1, employee2);
		
		
		when(employeeRepository.findByName(name)).thenReturn(ListOfEmployees);
		
		List<Employee> retrivedEmployeeList=employeeService.getEmployeeByName(name);
		
		assertEquals(ListOfEmployees.size(), retrivedEmployeeList.size());
		
	}
	
	@Test
	public void getEmployeeNameAndIdTest() {
		String name="prasanth";
		int id=1;
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setId(id);
		when(employeeRepository.findByNameAndId(name, id)).thenReturn(employee);

		Employee findByNameAndId = employeeRepository.findByNameAndId(name, id);
		
		assertEquals(employee,findByNameAndId );
		
	}
	
	@Test
	public void getEmployeesBySalaryTest() {
		double salary =10000;
		
		Employee employee1 = new Employee();	
		employee1.setSalary(salary);
		
		Employee employee2 = new Employee();
		employee2.setSalary(salary);
		
		List<Employee> salaryList= Arrays.asList(employee1, employee2);
		
	
		when(employeeRepository.findBySalary(salary)).thenReturn(salaryList);
		
		List<Employee> retrivedSalaryList = employeeService.getEmployeesBySalary(salary);
		
		assertEquals(salaryList.size(), retrivedSalaryList.size());
		
		
		
	}
	

	
	@Test
	public void testupdateEmployee() {
		int id=1;
		
		Employee exsitingemployee = new Employee();
		exsitingemployee.setId(id);
		exsitingemployee.setName("prasanth");
		exsitingemployee.setEmail_id("123@cognizant.com");
		exsitingemployee.setDepartment_id(1);
		exsitingemployee.setDepartmet_name("Microservice");
		exsitingemployee.setSalary(1000.0);
		exsitingemployee.setDesignation("PA");
		
		
		Employee updatedEmployee= new Employee();
		
		updatedEmployee.setName("prasanth");
		updatedEmployee.setEmail_id("123@cognizant.com");
		updatedEmployee.setDepartment_id(1);
		updatedEmployee.setDepartmet_name("Microservice");
		updatedEmployee.setSalary(10000.0);
		updatedEmployee.setDesignation("PA");
		
		when(employeeRepository.findById(id)).thenReturn(Optional.of(exsitingemployee));
		
		when(employeeRepository.save(exsitingemployee)).thenReturn(exsitingemployee);
		
		Employee result=employeeService.updateEmployee( updatedEmployee);
		
		
		assertEquals(updatedEmployee.getName(), result.getName());
		//assertEquals.(updatedEmployee.getEmail_id(), result.getEmail_id());
		assertEquals(updatedEmployee.getEmail_id(),result.getEmail_id());
		assertEquals(updatedEmployee.getDepartment_id(), result.getDepartment_id());
		assertEquals(updatedEmployee.getDepartmet_name(), result.getDepartmet_name());
		assertEquals(updatedEmployee.getSalary(),result.getSalary());
		assertEquals(updatedEmployee.getDesignation(),result.getDesignation());
	}
	
	@Test
	public void testDelete() {
		int id =1;

		employeeService.deleteEmployee(id);
		
		assertTrue(employeeService.getEmployeeId(id).isEmpty());
		
	}
	
	
	
	

}

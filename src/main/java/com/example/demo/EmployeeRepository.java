package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	
	Employee findByNameAndId(String name, int id);
	List<Employee> findByName(String name);
	List<Employee> findBySalary(Double salary);
}

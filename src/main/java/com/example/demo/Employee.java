package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String email_id;

	private int department_id;
	
	private String departmet_name;
	
	private Double salary;
	
	private String Designation;
	
	public Employee() {
		
	}


	public Employee(int id, String name, String email_id, int department_id, String departmet_name, Double salary,
			String designation) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.department_id = department_id;
		this.departmet_name = departmet_name;
		this.salary = salary;
		Designation = designation;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartmet_name() {
		return departmet_name;
	}

	public void setDepartmet_name(String departmet_name) {
		this.departmet_name = departmet_name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email_id=" + email_id + ", department_id=" + department_id
				+ ", departmet_name=" + departmet_name + ", salary=" + salary + ", Designation=" + Designation + "]";
	}
	
}

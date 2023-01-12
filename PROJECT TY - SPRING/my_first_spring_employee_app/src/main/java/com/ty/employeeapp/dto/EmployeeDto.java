package com.ty.employeeapp.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@Entity
@Table(name="employees_table")
public class EmployeeDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int id;
	@Column(name="emp_name")
	private String name;
	@NotNull
	@Size(min = 1, max = 100)
	@Email(message = "^([a-zA-Z0-9\\\\-\\\\.\\\\_]+)'+'(\\\\@)([a-zA-Z0-9\\\\-\\\\.]+)'+'(\\\\.)([a-zA-Z]{2,4})$")
	@Column(name="emp_email")
	private String email;
	@Column(name="emp_salary")
	private double salary;
	@Column(name="emp_status")
	private boolean statusType;
	@Column(name="emp_dob")
	private LocalDate dob;
	@Column(name="emp_age")
	private int age;

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean getStatusType() {
		return statusType;
	}
	public void setStatusType(boolean statusType) {
		this.statusType = statusType;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int i) {
		this.age = i;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", status="
				+ statusType + ", dob=" + dob + ", age=" + age + "]";
	}




}

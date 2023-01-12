package com.ty.employeeapp.beans;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private boolean statusType;
	private String dob;
	private String email;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", status=" + statusType + ", dob=" + dob
				+ ", email=" + email + ", age=" + age + "]";
	}
	
}

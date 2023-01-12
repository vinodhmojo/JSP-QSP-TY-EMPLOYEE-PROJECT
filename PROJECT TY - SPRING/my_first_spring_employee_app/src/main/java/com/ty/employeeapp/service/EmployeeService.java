package com.ty.employeeapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.employeeapp.beans.Employee;
import com.ty.employeeapp.dao.EmployeeDao;
import com.ty.employeeapp.dto.EmployeeDto;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDto addEmployee(Employee employee) {

		EmployeeDto dto = new EmployeeDto();
		dto.setName(employee.getName());
		dto.setEmail(employee.getEmail());
		dto.setSalary(employee.getSalary());
		dto.setDob(LocalDate.parse(employee.getDob()));
		dto.setAge(LocalDate.now().getYear() - LocalDate.parse(employee.getDob()).getYear());
		dto.setStatusType(employee.getStatusType());
		return employeeDao.insetEmployee(dto);
	}

	public EmployeeDto searchEmployee(int id) {
		return employeeDao.searchEmployee(id);
	}

	public List<EmployeeDto> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public EmployeeDto updateEmployee(int id, Employee employee) {
		EmployeeDto dto=new EmployeeDto();
		
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setEmail(employee.getEmail());
		dto.setSalary(employee.getSalary());
		dto.setDob(LocalDate.parse(employee.getDob()));
		dto.setAge(LocalDate.now().getYear() - LocalDate.parse(employee.getDob()).getYear());
		dto.setStatusType(employee.getStatusType());
		return employeeDao.updateEmployee(dto);
	}

	public EmployeeDto deleteEmployee(int id) {
		EmployeeDto allEmps=employeeDao.searchEmployee(id);
		if (allEmps==null) {
			return null;
		}else {
			return employeeDao.deleteEmployee(allEmps);
		}
	}


}

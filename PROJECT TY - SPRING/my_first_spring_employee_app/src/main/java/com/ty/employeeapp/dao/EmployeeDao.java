package com.ty.employeeapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.employeeapp.dto.EmployeeDto;

@Repository
public class EmployeeDao {

	@Autowired
	private  EntityManagerFactory factory;

	public EmployeeDto insetEmployee(EmployeeDto newEmployeeDto) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(newEmployeeDto);
			transaction.commit();
			return newEmployeeDto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	}

	public EmployeeDto searchEmployee(int id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(EmployeeDto.class, id);
	}

	public List<EmployeeDto> getAllEmployees() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM EmployeeDto");
		return query.getResultList();
	}

	public EmployeeDto updateEmployee(EmployeeDto dto) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.merge(dto);
			transaction.commit();
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}


	}

	public EmployeeDto deleteEmployee(EmployeeDto allEmps) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			EmployeeDto dto= manager.merge(allEmps);
			manager.remove(dto);
			transaction.commit();
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}	
	}
}
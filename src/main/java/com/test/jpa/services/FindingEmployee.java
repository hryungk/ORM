package com.test.jpa.services;

import com.test.jpa.models.EmployeeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindingEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entitymanager = emfactory.createEntityManager();
		EmployeeEntity employee = entitymanager.find(EmployeeEntity.class, 1056);
		if (employee != null)
			System.out.println(employee.toString());
		else
			System.out.println("employee not found.");
		entitymanager.close();
		emfactory.close();
		
	}
	
	public EmployeeEntity findEmployee(int eid) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, eid);
		entityManager.close();
		emfactory.close();
		return employee;
	}
}

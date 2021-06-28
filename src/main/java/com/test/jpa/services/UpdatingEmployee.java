package com.test.jpa.services;

import com.test.jpa.models.EmployeeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdatingEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, 1056);
		
		System.out.println(employee);
		
		System.out.println("After Update");
		employee.setEmail("mpatterson@classicmodelcars.com");
		entityManager.getTransaction().commit();
		
//		System.out.println("employee EMAIL = " + employee.getEmail());
		System.out.println(employee);
		entityManager.close();
		emfactory.close();
	}
	
	public void updateEmployeeEmail(int eid, String email) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, eid);
		employee.setEmail(email);
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
	}
}

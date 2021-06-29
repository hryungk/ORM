package com.test.jpa.services;

import com.test.jpa.models.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdatingEmployee {
	public static void main(String[] args) {
//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
//		EntityManager entityManager = emfactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, 1056);
//		
//		System.out.println(employee);
//		
//		System.out.println("After Update");
//		employee.setEmail("mpatterson@classicmodelcars.com");
//		entityManager.getTransaction().commit();
//		
////		System.out.println("employee EMAIL = " + employee.getEmail());
//		System.out.println(employee);
//		entityManager.close();
//		emfactory.close();
		
		// Test JPQL method
		String email = "dmurphy@classicmodelcars.com";
//		String email = "xyz@classicmodelcars.com";
		updateEmployeeEmail_JPQL(1002, email);
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
	
	public static void updateEmployeeEmail_JPQL(int eid, String email) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, eid);
		System.out.println("Before Update: \n" + employee);
		
		Query query = entityManager.createQuery("UPDATE EmployeeEntity e SET e.email = :newEmail WHERE e.employeeNumber = :num");
		query.setParameter("num", eid);
		query.setParameter("newEmail", email);
		query.executeUpdate();
		
		entityManager.getTransaction().commit();
		
		entityManager.refresh(employee);
		
		System.out.println("After Update: \n" + employee);
		
		entityManager.close();
		emfactory.close();
	}
}

package com.test.jpa.services;

import com.test.jpa.models.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreatingEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		EmployeeEntity employee = new EmployeeEntity();
		employee.setEmail("amick@email.com");
		employee.setFirstName("Alex");
		employee.setLastName("Mick");
		employee.setEmployeeNumber(23);
		employee.setOfficeCode(1);
		
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		emfactory.close();
	}

	public void createEmployee(EmployeeEntity newEmployee) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newEmployee);
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
	}
	
}

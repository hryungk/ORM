package com.test.jpa.services;

import com.test.jpa.models.EmployeeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DeletingEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, 23);
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		emfactory.close();
	}
	
	public void deleteEmployee(int eid) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, eid);
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
	}

}

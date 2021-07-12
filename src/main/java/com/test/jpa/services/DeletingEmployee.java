package com.test.jpa.services;

import com.test.jpa.models.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	public static void deleteEmployeeEmail_JPQL(int eid) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();		
		Query query = entityManager.createQuery("DELETE FROM EmployeeEntity e WHERE e.employeeNumber = :num");
		query.setParameter("num", eid);
		query.executeUpdate();		
		entityManager.getTransaction().commit();		
		entityManager.close();
		emfactory.close();
	}

}

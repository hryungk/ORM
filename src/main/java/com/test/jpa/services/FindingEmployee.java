package com.test.jpa.services;

import java.util.List;

import com.test.jpa.models.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class FindingEmployee {

	public static void main(String[] args) {
//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
//		EntityManager entitymanager = emfactory.createEntityManager();
//		EmployeeEntity employee = entitymanager.find(EmployeeEntity.class, 1056);
//		if (employee != null)
//			System.out.println(employee.toString());
//		else
//			System.out.println("employee not found.");
//		entitymanager.close();
//		emfactory.close();
		
//		getAllEmployees_JPQL();
		findEmployeeByNumber_JPQL(1002);
		
	}
	
	public EmployeeEntity findEmployee(int eid) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, eid);
		entityManager.close();
		emfactory.close();
		return employee;
	}

	public static void getAllEmployees_JPQL() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		
//		// Create a query dynamically within business logic
//		Query query = entityManager.createQuery("SELECT e FROM EmployeeEntity e");
		// Create a query statically within the entity using @NamedQuery annotation
		Query query = entityManager.createNamedQuery("findAll");
		
		List<?> employees = query.getResultList();
		
//		// Use a TypedQuery to specify the type of output object by passing in the class parameter.
//		TypedQuery<EmployeeEntity> query = entityManager.createNamedQuery("findAll", EmployeeEntity.class);
//		List<EmployeeEntity> employees = query.getResultList();
		
		employees.forEach(System.out::println);
		
		entityManager.close();
		emfactory.close();
	}
	
	public static void findEmployeeByNumber_JPQL(int eid) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		
//		Query query = entityManager.createQuery("SELECT e FROM EmployeeEntity e WHERE e.employeeNumber = :givenID");
		Query query = entityManager.createNamedQuery("find_Employee_By_ID");
		query.setParameter("givenID", eid);
		EmployeeEntity employee = (EmployeeEntity) query.getSingleResult();
		
//		TypedQuery<EmployeeEntity> query = entityManager.createNamedQuery("find_Employee_By_ID", EmployeeEntity.class);
//		query.setParameter("givenID", eid);
//		EmployeeEntity employee = query.getSingleResult();
		
		System.out.println(employee);
		
		entityManager.close();
		emfactory.close();
	}
}

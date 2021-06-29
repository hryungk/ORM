package com.test.jpa.services;

import com.test.jpa.models.Office;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OfficeService {
	public static void main(String[] args) {
		// Find an office
		OfficeService os = new OfficeService();
		Office office = os.findOffice(8);
		System.out.println(office);
		
		// Create an office
		Office newOffice = new Office("8","Seattle","+1 123 456 7830", "123 Pine Street", "Suite 101","WA","USA","98105","NA");
		os.createOffice(newOffice);
		office = os.findOffice(8);
		System.out.println("Newly added:\n" + office);
		
		// Update an office
		office = os.findOffice(8);
		office.setAddressLine2("Suite 302");
		os.updateOffice(office);
		System.out.println("Office updated:\n" + office);
		
		// Delete an office
		os.deleteOffice(office.getOfficeCode());
		
	}
	
	public Office findOffice(int oid) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		Office office = entityManager.find(Office.class, Integer.toString(oid));
		entityManager.close();
		emfactory.close();
		return office;
	}
	public Office findOffice(String oid) {
		return findOffice(Integer.parseInt(oid));
	}
	
	public void createOffice(Office newOffice) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newOffice);
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
	}
	
	public void updateOffice(Office ofc) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		Office office = entityManager.find(Office.class, ofc.getOfficeCode());
		office.setCity(ofc.getCity());
		office.setPhone(ofc.getPhone());
		office.setAddressLine1(ofc.getAddressLine1());
		office.setAddressLine2(ofc.getAddressLine2());
		office.setState(ofc.getState());
		office.setCountry(ofc.getCountry());
		office.setPostalCode(ofc.getPostalCode());
		office.setTerritory(ofc.getTerritory());
		entityManager.persist(office);
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
	}
	
	public void deleteOffice(int oid) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Test2");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		Office office = entityManager.find(Office.class, Integer.toString(oid));
		entityManager.remove(office);
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
	}
	public void deleteOffice(String oid) {
		deleteOffice(Integer.parseInt(oid));
	}
}

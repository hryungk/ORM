package com.test.jpa.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="employees")
@NamedQuery(name = "findAll", query = "SELECT e from EmployeeEntity e")
@NamedQuery(name = "find_Employee_By_ID", query = "SELECT e FROM EmployeeEntity e WHERE e.employeeNumber = :givenID")
public class EmployeeEntity {

	@Id
	int employeeNumber;
	String firstName;
	String lastName;
	String email;
	int officeCode;
	
	public EmployeeEntity() {
		super();
	}
	
	public EmployeeEntity(int employeeNumber, String firstName, String lastName, String email, int officeCode) {
		super();
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.officeCode = officeCode;
	}
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(int officeCode) {
		this.officeCode = officeCode;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeNumber=" + employeeNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", officeCode=" + officeCode + "]";
	}
	
	
	
}

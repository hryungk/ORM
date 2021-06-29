package com.test.jpa.models;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Office
 *
 */
@Entity
@Table(name="offices")

public class Office implements Serializable {

	@Id
	private String officeCode;
	private String city;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	private String territory;
	private static final long serialVersionUID = 1L;

	// Constructor without address line 2 and state
	public Office(String officeCode, String city, String phone, String addressLine1, String country, String postalCode,
			String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}
	

	// Constructor with all fields
	public Office(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state,
			String country, String postalCode, String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}

	public Office() {
		super();
	}   
	public String getOfficeCode() {
		return this.officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}   
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}   
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}   
	public String getTerritory() {
		return this.territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}
	
	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory + "]";
	}
	
	
   
}

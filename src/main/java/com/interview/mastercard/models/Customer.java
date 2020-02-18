package com.interview.mastercard.models;

import java.util.UUID;

public class Customer {
	private String firstName;
	private String lastName;
	private String uuid; // represents unique customer
	
	public Customer() {	
	}
	
	public Customer(CustomerRequestBody request) {
		this.uuid = UUID.randomUUID().toString();
		this.firstName = request.getFirstName();
		this.lastName = request.getLastName();
	}
	
	public Customer(String first, String last) {
		this.uuid = UUID.randomUUID().toString();
		this.firstName = first;
		this.lastName = last;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", uuid=" + uuid + "]";
	}
}

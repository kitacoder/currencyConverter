package com.interview.mastercard.models;

public class CustomerRequestBody {
	private String firstName;
	private String lastName;
	private CurrencyType currencyType;
	
	public CustomerRequestBody() {	
	}
	
	
	public CurrencyType getCurrencyType() {
		return currencyType;
	}


	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
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


	@Override
	public String toString() {
		return "CustomerRequestBody [firstName=" + firstName + ", lastName=" + lastName + ", currencyType="
				+ currencyType + "]";
	}
}

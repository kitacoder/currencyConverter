package com.interview.mastercard.models;

import java.util.UUID;

import com.interview.mastercard.exceptions.OverDraftException;

//Not a thread safe class
public class Account {
	
	private Customer customer;
	private String uuid; // represents unique account number
	private double balance;
	private CurrencyType currencyType;
	
	public Account() {	
	}
	
	public Account(Customer customer, double balance, CurrencyType currencyType) {
		
		if (balance < 0 || customer == null) {
			throw new IllegalArgumentException("Illegal input parameters");
		}
		this.uuid = UUID.randomUUID().toString();
		this.customer = customer;
		this.balance = balance;
		this.currencyType = currencyType;
	}
	
	public void withdraw(double sum) throws OverDraftException {
		double result = getBalance() - sum;
		if (result < 0) {
			throw new OverDraftException("Withdrawal amount is greater than what is available to withdraw");
		}
		
		this.balance = result;
	}

	public void debit(double sum) {
		if (sum < 0) {
			throw new IllegalArgumentException("You cannot debit a negative amount");
		}
		
		this.balance += sum;
	}
	
	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getUuid() {
		return uuid;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [customer=" + customer + ", uuid=" + uuid + ", balance=" + balance + "]";
	}
}

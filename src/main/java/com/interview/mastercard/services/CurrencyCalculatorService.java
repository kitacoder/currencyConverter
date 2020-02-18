package com.interview.mastercard.services;

import java.io.FileNotFoundException;

import com.interview.mastercard.models.Account;
import com.interview.mastercard.models.CurrencyCalculatorServiceResponse;

public interface CurrencyCalculatorService {
	
	CurrencyCalculatorServiceResponse process(Account fromAcct, Account toAcct, double amount) throws FileNotFoundException;

}

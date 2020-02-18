package com.interview.mastercard.services;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.mastercard.models.Account;
import com.interview.mastercard.models.CurrencyCalculatorServiceResponse;
import com.interview.mastercard.models.Customer;
import com.interview.mastercard.models.CustomerRequestBody;
import com.interview.mastercard.models.FundAccountRequestBody;
import com.interview.mastercard.models.Pair;
import com.interview.mastercard.models.TransferFundsRequestBody;

@Service
public class AccountOrchestrator {
	
	@Autowired
	private AccountService acctService;
	
	@Autowired
	private CurrencyCalculatorService currencyCalculatorService;
	
	public AccountOrchestrator() {
		
	}
	
	public Account getAccount(String id) {
		return acctService.getAccount(id);
	}

	public Account createAccount(CustomerRequestBody request) {
		Account account = new Account(new Customer(request), 0, request.getCurrencyType()); 
		return acctService.createAccount(account);
	}
	
	public Account fundAccount(FundAccountRequestBody request) {
		return acctService.fundAccount(request.getAccountUuid(), request.getCustomerUuid(), request.getAmount());
	}
	
	public Pair transferFunds(TransferFundsRequestBody request) {
		Account fromAcct = acctService.getAccount(request.getFromAcctUuid());
		Account toAcct = acctService.getAccount(request.getToAcctUuid());
		CurrencyCalculatorServiceResponse result = null;
		try {
			result = currencyCalculatorService.process(fromAcct, toAcct, request.getAmount());
			fromAcct.withdraw( (request.getAmount() * result.getConversionRate() ) + result.getBankFee());
			toAcct.debit(result.getTransAmt());
			
		} catch (FileNotFoundException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
		
		return new Pair(fromAcct, toAcct);
	}
}

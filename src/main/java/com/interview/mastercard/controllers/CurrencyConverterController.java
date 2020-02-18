package com.interview.mastercard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.mastercard.models.Account;
import com.interview.mastercard.models.AccountResponseBody;
import com.interview.mastercard.models.CustomerRequestBody;
import com.interview.mastercard.models.FundAccountRequestBody;
import com.interview.mastercard.models.Pair;
import com.interview.mastercard.models.TransferFundsRequestBody;
import com.interview.mastercard.models.TransferFundsResponseBody;
import com.interview.mastercard.services.AccountOrchestrator;
import com.interview.mastercard.validator.Validator;

@RestController
public class CurrencyConverterController {
	
	@Autowired
	private AccountOrchestrator acctOrchestrator;
	
	@Autowired
	private Validator validator;

	@PostMapping("/create-account")
	public ResponseEntity<AccountResponseBody> createAccount(@RequestBody CustomerRequestBody requestBody) {
		AccountResponseBody response = null;
		
	    if (!validator.validate(requestBody)) {
			response = new AccountResponseBody(null, "Invalid customer input");
			return new ResponseEntity<AccountResponseBody>(response, HttpStatus.BAD_REQUEST);
		}
	    
		Account acct = acctOrchestrator.createAccount(requestBody);
		response = new AccountResponseBody(acct, "success");
		return new ResponseEntity<AccountResponseBody>(response, HttpStatus.OK);
	}
	
	@PostMapping("/fund-account")
	public ResponseEntity<AccountResponseBody> fundAccount(@RequestBody FundAccountRequestBody requestBody) {
		AccountResponseBody response = null;
		
	    if (!validator.validate(requestBody)) {
	    	response = new AccountResponseBody(null, "Could not validate input");
			return new ResponseEntity<AccountResponseBody>(response, HttpStatus.BAD_REQUEST);
		}
	    
		Account acct = acctOrchestrator.fundAccount(requestBody);
		response = new AccountResponseBody(acct, "success");
		return new ResponseEntity<AccountResponseBody>(response, HttpStatus.OK);
	}
	
	@PostMapping("/transfer-funds")
	public ResponseEntity<TransferFundsResponseBody> transferFunds(@RequestBody TransferFundsRequestBody requestBody) {
		TransferFundsResponseBody response = null;
		
		if (!validator.validate(requestBody)) {
			response = new TransferFundsResponseBody(null, null, "Could not validate input");
			return new ResponseEntity<TransferFundsResponseBody>(response, HttpStatus.BAD_REQUEST);
		}
		Pair accounts = acctOrchestrator.transferFunds(requestBody);
		response = new TransferFundsResponseBody(accounts.getFromAcct(), accounts.getToAcct(), "success");
		return new ResponseEntity<TransferFundsResponseBody>(response, HttpStatus.OK);
	}
}

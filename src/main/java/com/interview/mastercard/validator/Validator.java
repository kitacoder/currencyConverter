package com.interview.mastercard.validator;

import org.springframework.stereotype.Service;

import com.interview.mastercard.models.CustomerRequestBody;
import com.interview.mastercard.models.FundAccountRequestBody;
import com.interview.mastercard.models.TransferFundsRequestBody;

@Service
public class Validator {
	
	public boolean validate(CustomerRequestBody requestBody) {
		// could validate currenctyType is one of the allowed values
		if(requestBody == null || requestBody.getFirstName() == null || requestBody.getLastName() == null) {
			return false;
		}
		return true;
	}
	
	public boolean validate(FundAccountRequestBody requestBody) {
		//We could check verify the account uuid and customer uuid exist
		// We could validate the balance is positive
		return true;
	}

	public boolean validate(TransferFundsRequestBody requestBody) {
		//We could check verify the account uuids and customer uuids exist
		// Validate currency type is accepted and also validate currency type is set on an existing account
		// Validate the amount can be withdraw from one account and transfer to another
		// Anything with Transaction must be thread-safe and being able to roll-back the transaction
		return true;
	}
}

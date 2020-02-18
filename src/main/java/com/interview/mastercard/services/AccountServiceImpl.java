package com.interview.mastercard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.mastercard.models.Account;
import com.interview.mastercard.models.CurrencyType;
import com.interview.mastercard.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository repository;
	
	@Override
	public Account getAccount(String id) {
		return repository.getAccount(id);
	}

	@Override
	public Account createAccount(Account account) {
		
		boolean success = repository.createAccount(account);
		if(success) {
			return account;
		}
		return null;
	}

	@Override
	public Account fundAccount(String acctUuid, String customerUuid, double amount) {
		Account account = repository.getAccount(acctUuid);
		if (account == null) {
			return null;
		}
		
		account.debit(amount);
		return account;
	}

	@Override
	public Account transferFunds(String fromAcctUuid, String fromCustomerUuid, String toAcctUuid, String toCustomerUuid,
			double amount, CurrencyType toCurrencyType) {
		// TODO Auto-generated method stub
		return null;
	}
}

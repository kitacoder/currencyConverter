package com.interview.mastercard.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.interview.mastercard.models.Account;

@Service
public class AccountRepositoryImpl implements AccountRepository{

	private Map<String, Account> map = new HashMap<>();
	
	@Override
	public Account getAccount(String id) {
		if (id == null || id.trim() == "") {
			return null;
		}
		return map.get(id);
	}

	@Override
	public boolean createAccount(Account acct) {
		if(!map.containsKey(acct.getUuid().toString())) {
			map.put(acct.getUuid(), acct);
			return true;
		} 
		return false;
	}

}

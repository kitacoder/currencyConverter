package com.interview.mastercard.repository;

import org.springframework.stereotype.Service;

import com.interview.mastercard.models.Account;

@Service
public interface AccountRepository {
    Account getAccount(String id);
    boolean createAccount(Account acct);
}

package com.interview.mastercard.services;

import com.interview.mastercard.models.Account;
import com.interview.mastercard.models.CurrencyType;

public interface AccountService {
    Account getAccount(String id);
    Account createAccount(Account acct);
    Account fundAccount(String acctUuid, String customerUuid, double amount);
    Account transferFunds(String fromAcctUuid, String fromCustomerUuid, String toAcctUuid, String toCustomerUuid, double amount, CurrencyType toCurrencyType);
}

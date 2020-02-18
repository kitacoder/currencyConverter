package com.interview.mastercard.models;

public class FundAccountRequestBody {
	private String customerUuid;
	private String accountUuid;
	private double amount;
	
	public FundAccountRequestBody() {
	}

	
	public String getAccountUuid() {
		return accountUuid;
	}


	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}


	public String getCustomerUuid() {
		return customerUuid;
	}

	public void setCustomerUuid(String customerUuid) {
		this.customerUuid = customerUuid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "FundAccountRequestBody [customerUuid=" + customerUuid + ", accountUuid=" + accountUuid + ", amount="
				+ amount + "]";
	}
}

package com.interview.mastercard.models;

public class TransferFundsRequestBody {
	private String fromAcctUuid;
	private String fromCustomerUuid;
	private String toAcctUuid;
	private String toCustomerUuid;
	private double amount;
	private CurrencyType toCurrencyType;
	
	public TransferFundsRequestBody() {
	}

	public String getFromAcctUuid() {
		return fromAcctUuid;
	}

	public void setFromAcctUuid(String fromAcctUuid) {
		this.fromAcctUuid = fromAcctUuid;
	}

	public String getFromCustomerUuid() {
		return fromCustomerUuid;
	}

	public void setFromCustomerUuid(String fromCustomerUuid) {
		this.fromCustomerUuid = fromCustomerUuid;
	}

	public String getToAcctUuid() {
		return toAcctUuid;
	}

	public void setToAcctUuid(String toAcctUuid) {
		this.toAcctUuid = toAcctUuid;
	}

	public String getToCustomerUuid() {
		return toCustomerUuid;
	}

	public void setToCustomerUuid(String toCustomerUuid) {
		this.toCustomerUuid = toCustomerUuid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CurrencyType getToCurrencyType() {
		return toCurrencyType;
	}

	public void setToCurrencyType(CurrencyType toCurrencyType) {
		this.toCurrencyType = toCurrencyType;
	}

	@Override
	public String toString() {
		return "TransferFundsRequestBody [fromAcctUuid=" + fromAcctUuid + ", fromCustomerUuid=" + fromCustomerUuid
				+ ", toAcctUuid=" + toAcctUuid + ", toCustomerUuid=" + toCustomerUuid + ", amount=" + amount
				+ ", toCurrencyType=" + toCurrencyType + "]";
	}
}

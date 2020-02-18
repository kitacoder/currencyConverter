package com.interview.mastercard.models;

public class TransferFundsResponseBody {
	private Account fromAcct;
	private Account toAcct;
	private String developerText;
	
	public TransferFundsResponseBody() {
	}

	public TransferFundsResponseBody(Account fromAcct, Account toAcct, String developerText) {
		this.fromAcct = fromAcct;
		this.toAcct = toAcct;
		this.developerText = developerText;
	}
	
	public Account getFromAcct() {
		return fromAcct;
	}

	public void setFromAcct(Account fromAcct) {
		this.fromAcct = fromAcct;
	}

	public Account getToAcct() {
		return toAcct;
	}

	public void setToAcct(Account toAcct) {
		this.toAcct = toAcct;
	}

	public String getDeveloperText() {
		return developerText;
	}

	public void setDeveloperText(String developerText) {
		this.developerText = developerText;
	}

	@Override
	public String toString() {
		return "TransferFundsResponseBody [fromAcct=" + fromAcct + ", toAcct=" + toAcct + ", developerText="
				+ developerText + "]";
	}
}

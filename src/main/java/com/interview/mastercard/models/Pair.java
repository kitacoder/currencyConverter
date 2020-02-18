package com.interview.mastercard.models;

public class Pair {
	private Account fromAcct;
	private Account toAcct;
	
	public Pair() {
	}

	public Pair(Account from, Account to) {
		this.fromAcct = from;
		this.toAcct = to;
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

	@Override
	public String toString() {
		return "Pair [fromAcct=" + fromAcct + ", toAcct=" + toAcct + "]";
	}
}

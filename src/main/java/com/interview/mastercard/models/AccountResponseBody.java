package com.interview.mastercard.models;

public class AccountResponseBody {
	
	private Account data;
	private String developerText;
	
	public AccountResponseBody() {	
	}
	
	public AccountResponseBody(Account data, String developerText) {
		this.data = data;
		this.developerText = developerText;
	}
	
	
	public Account getData() {
		return data;
	}

	public void setData(Account data) {
		this.data = data;
	}

	public String getDeveloperText() {
		return developerText;
	}

	public void setDeveloperText(String developerText) {
		this.developerText = developerText;
	}

	@Override
	public String toString() {
		return "AccountResponseBody [data=" + data + ", developerText=" + developerText + "]";
	}
}

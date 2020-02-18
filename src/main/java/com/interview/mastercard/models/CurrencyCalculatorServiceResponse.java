package com.interview.mastercard.models;

public class CurrencyCalculatorServiceResponse {
    private double conversionRate;
    private double crdhldBillAmt;
    private double transAmt;
    private double bankFee;
    
	public double getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}
	public double getCrdhldBillAmt() {
		return crdhldBillAmt;
	}
	public void setCrdhldBillAmt(double crdhldBillAmt) {
		this.crdhldBillAmt = crdhldBillAmt;
	}
	public double getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(double transAmt) {
		this.transAmt = transAmt;
	}
	public double getBankFee() {
		return bankFee;
	}
	public void setBankFee(double bankFee) {
		this.bankFee = bankFee;
	}
	@Override
	public String toString() {
		return "CurrencyCalculatorServiceResponse [conversionRate=" + conversionRate + ", crdhldBillAmt="
				+ crdhldBillAmt + ", transAmt=" + transAmt + ", bankFee=" + bankFee + "]";
	}
    
    
}

package com.interview.mastercard.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.interview.mastercard.models.Account;
import com.interview.mastercard.models.CurrencyCalculatorServiceResponse;
import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.ApiException;
import com.mastercard.api.core.model.Environment;
import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.core.model.map.SmartMap;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.currencyconversion.ConversionRate;

@Service
public class CurrencyCalculatorImpl implements CurrencyCalculatorService {

	@Override
	public CurrencyCalculatorServiceResponse process(Account fromAcct, Account toAcct, double amount) throws FileNotFoundException {
		
		   String consumerKey = "INSERT-YOUR-CONSUMER-KEY HERE. I REMOVED MINE";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
		   String keyAlias = "keyalias";   // For production: change this to the key alias you chose when you created your production key
		   String keyPassword = "keystorepassword";   // For production: change this to the key alias you chose when you created your production key
		   InputStream is = new FileInputStream("/Users/Waraba/Developer/pk2/MCD_Sandbox_CurrencyConverter_API_Keys/CurrencyConverter-sandbox.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
		   ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
		   ApiConfig.setDebug(true);   // Enable http wire logging
		   // This is needed to change the environment to run the sample code. For production: use ApiConfig.setSandbox(false);
		   ApiConfig.setEnvironment(Environment.parse("sandbox_mtf"));
		
			     RequestMap map = new RequestMap();
			     map.set("fxDate", "2019-09-30");
			     map.set("transCurr", toAcct.getCurrencyType().name());
			     map.set("crdhldBillCurr", fromAcct.getCurrencyType().name());
			     map.set("bankFee", "5");
			     map.set("transAmt", amount);

			     ConversionRate response;
			     CurrencyCalculatorServiceResponse result = null;
				try {
					response = ConversionRate.query(map);
				    result = new CurrencyCalculatorServiceResponse();
				    
				    Long bankFee = (Long)response.get("data.bankFee");
				    result.setBankFee(bankFee);
				    
				    Double conversionRate = (Double)response.get("data.conversionRate");
				    result.setConversionRate(conversionRate);
				    
				    Double crdhldBillAmt = (Double)response.get("data.crdhldBillAmt");
				    result.setCrdhldBillAmt(crdhldBillAmt);
				    
				    Double transAmt = (Double)response.get("data.transAmt");
				    result.setTransAmt(transAmt);
				} catch (ApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	    
		return result;
	}
	
	 public static void out(SmartMap response, String key) {
		   System.out.println(key+"-->"+response.get(key));
		 }

		 public static void out(Map<String,Object> map, String key) {
		   System.out.println(key+"--->"+map.get(key));
		 }

		 public static void err(String message) {
		   System.err.println(message);
		 }

}

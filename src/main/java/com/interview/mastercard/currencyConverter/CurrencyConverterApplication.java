package com.interview.mastercard.currencyConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.interview.mastercard.controllers")
@ComponentScan("com.interview.mastercard.services")
@ComponentScan("com.interview.mastercard.repository")
@ComponentScan("com.interview.mastercard.validator")
public class CurrencyConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

}

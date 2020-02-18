package com.interview.mastercard.exceptions;

public class OverDraftException extends Exception { 
	private static final long serialVersionUID = 1L;

	public OverDraftException(String errorMessage) {
        super(errorMessage);
    }
}
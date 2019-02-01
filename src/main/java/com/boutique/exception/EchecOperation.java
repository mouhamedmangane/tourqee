package com.boutique.exception;

public class EchecOperation extends RuntimeException {

	public EchecOperation() {
		super();
	}

	public EchecOperation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EchecOperation(String message, Throwable cause) {
		super(message, cause);
	}

	public EchecOperation(String message) {
		super(message);
	}

	public EchecOperation(Throwable cause) {
		super(cause);
	}
	
}

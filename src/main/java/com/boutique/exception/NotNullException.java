package com.boutique.exception;

public class NotNullException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotNullException() {
		super();
	}

	public NotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotNullException(String message) {
		super(message);
	}

	public NotNullException(Throwable cause) {
		super(cause);
	}

}

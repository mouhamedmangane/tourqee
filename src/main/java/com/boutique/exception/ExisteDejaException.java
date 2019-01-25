package com.boutique.exception;

public class ExisteDejaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExisteDejaException() {
		super();
	}

	public ExisteDejaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExisteDejaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExisteDejaException(String message) {
		super(message);
	}

	public ExisteDejaException(Throwable cause) {
		super(cause);
	}
	
}

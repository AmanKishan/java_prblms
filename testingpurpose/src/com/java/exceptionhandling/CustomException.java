package com.java.exceptionhandling;

public class CustomException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 777787L;
	
	private final  String errorCode ;
	
	
	public CustomException(String errorCode) {
	
		this.errorCode = errorCode;
	}

	public CustomException(String message,String errorCode) {
		
		super(message);
		this.errorCode = errorCode;
		
	}
	
	
	public CustomException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	public CustomException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}
	
	
	
	
}

package com.rai.exception;

public class MyAppException extends RuntimeException{
	
	public MyAppException(String message) {
		super(message);
	}
	
	public MyAppException(String message, Throwable cause) {
		super(message, cause);
	}

}

package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException    {
	
	public UserNotFoundException(String message) {
//		System.err.println(message+"message");
		
		super(message);
	}

}

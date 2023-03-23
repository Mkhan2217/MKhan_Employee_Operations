package com.example.demo.error;

public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException() {
		
	}
	public EmployeeNotFoundException(String message) {
		super(message);
	}


}

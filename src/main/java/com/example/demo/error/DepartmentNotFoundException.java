package com.example.demo.error;

public class DepartmentNotFoundException extends Exception {

	public DepartmentNotFoundException() {
		 
	}
	public DepartmentNotFoundException(String message) {
		super(message);		 
	}

}

package com.app.arnab.exception;

// Custom exception for an employee who does not exist
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8210420475041436992L;

	// Constructor accepts the exception message
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}

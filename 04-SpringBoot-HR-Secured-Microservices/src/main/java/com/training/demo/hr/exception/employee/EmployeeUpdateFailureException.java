package com.training.demo.hr.exception.employee;

public class EmployeeUpdateFailureException extends Exception{

	public EmployeeUpdateFailureException() {
		super();
	}

	public EmployeeUpdateFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeUpdateFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeUpdateFailureException(String message) {
		super(message);
	}

	public EmployeeUpdateFailureException(Throwable cause) {
		super(cause);
	}

}

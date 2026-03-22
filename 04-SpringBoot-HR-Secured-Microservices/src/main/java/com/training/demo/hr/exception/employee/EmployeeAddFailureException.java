package com.training.demo.hr.exception.employee;

public class EmployeeAddFailureException extends Exception{

	public EmployeeAddFailureException() {
		super();
	}

	public EmployeeAddFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeAddFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeAddFailureException(String message) {
		super(message);
	}

	public EmployeeAddFailureException(Throwable cause) {
		super(cause);
	}

}

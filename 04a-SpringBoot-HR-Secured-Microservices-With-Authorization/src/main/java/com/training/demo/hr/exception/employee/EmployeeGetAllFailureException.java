package com.training.demo.hr.exception.employee;

public class EmployeeGetAllFailureException extends Exception{

	public EmployeeGetAllFailureException() {
		super();
	}

	public EmployeeGetAllFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeGetAllFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeGetAllFailureException(String message) {
		super(message);
	}

	public EmployeeGetAllFailureException(Throwable cause) {
		super(cause);
	}

}

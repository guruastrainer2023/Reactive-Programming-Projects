package com.training.demo.hr.exception.employee;

public class EmployeeGetFailureException extends Exception{

	public EmployeeGetFailureException() {
		super();
	}

	public EmployeeGetFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeGetFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeGetFailureException(String message) {
		super(message);
	}

	public EmployeeGetFailureException(Throwable cause) {
		super(cause);
	}

}

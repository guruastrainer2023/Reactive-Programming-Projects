package com.training.demo.hr.exception.employee;

public class EmployeeDeleteFailureException extends Exception {

	public EmployeeDeleteFailureException() {
		super();
	}

	public EmployeeDeleteFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeDeleteFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeDeleteFailureException(String message) {
		super(message);
	}

	public EmployeeDeleteFailureException(Throwable cause) {
		super(cause);
	}

}

package com.training.demo.hr.exception.department;

public class DepartmentUpdateFailureException extends Exception{

	public DepartmentUpdateFailureException() {
		super();
		
	}

	public DepartmentUpdateFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public DepartmentUpdateFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentUpdateFailureException(String message) {
		super(message);
	}

	public DepartmentUpdateFailureException(Throwable cause) {
		super(cause);
	}

}

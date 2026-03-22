package com.training.demo.hr.exception.department;

public class DepartmentAddFailureException extends Exception{

	public DepartmentAddFailureException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentAddFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

	public DepartmentAddFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentAddFailureException(String message) {
		super(message);
	}

	public DepartmentAddFailureException(Throwable cause) {
		super(cause);
	}
	
}

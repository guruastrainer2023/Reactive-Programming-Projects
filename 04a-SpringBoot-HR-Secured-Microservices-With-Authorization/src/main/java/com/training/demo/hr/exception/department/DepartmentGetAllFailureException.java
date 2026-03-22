package com.training.demo.hr.exception.department;

public class DepartmentGetAllFailureException extends Exception{

	public DepartmentGetAllFailureException() {
		super();
	}

	public DepartmentGetAllFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DepartmentGetAllFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentGetAllFailureException(String message) {
		super(message);
	}

	public DepartmentGetAllFailureException(Throwable cause) {
		super(cause);
	}

}

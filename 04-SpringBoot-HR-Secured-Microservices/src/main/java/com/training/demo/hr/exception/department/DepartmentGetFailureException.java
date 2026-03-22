package com.training.demo.hr.exception.department;

public class DepartmentGetFailureException extends Exception{

	public DepartmentGetFailureException() {
		super();
	}

	public DepartmentGetFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DepartmentGetFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentGetFailureException(String message) {
		super(message);
	}

	public DepartmentGetFailureException(Throwable cause) {
		super(cause);
	}

}

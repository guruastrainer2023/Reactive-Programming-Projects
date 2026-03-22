package com.training.demo.hr.exception.department;

public class DepartmentDeleteFailureException extends Exception {

	public DepartmentDeleteFailureException() {
		super();
	}

	public DepartmentDeleteFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DepartmentDeleteFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentDeleteFailureException(String message) {
		super(message);
	}

	public DepartmentDeleteFailureException(Throwable cause) {
		super(cause);
	}

}

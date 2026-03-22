package com.training.response;

public class BookDeleteResponse {
	
	private int statusCode;
	
	private String description;

	public BookDeleteResponse(int statusCode, String description) {
		super();
		this.statusCode = statusCode;
		this.description = description;
	}

	public BookDeleteResponse() {
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

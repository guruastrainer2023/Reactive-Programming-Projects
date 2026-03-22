package com.training.response;

import com.training.bean.Book;

public class BookAddResponse {
	
	private int statusCode;
	private Book book;
	private String description;
	
	public BookAddResponse(int statusCode, Book book, String description) {
		super();
		this.statusCode = statusCode;
		this.book = book;
		this.description = description;
	}

	public BookAddResponse() {
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

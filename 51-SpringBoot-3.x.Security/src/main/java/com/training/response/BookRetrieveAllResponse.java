package com.training.response;

import java.util.List;

import com.training.bean.Book;

public class BookRetrieveAllResponse {
	
	private int statusCode;
	private List<Book> allBooks;
	private String desciption;
	
	public BookRetrieveAllResponse(int statusCode, List<Book> allBooks, String desciption) {
		super();
		this.statusCode = statusCode;
		this.allBooks = allBooks;
		this.desciption = desciption;
	}

	public BookRetrieveAllResponse() {
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Book> getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(List<Book> allBooks) {
		this.allBooks = allBooks;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
	

}

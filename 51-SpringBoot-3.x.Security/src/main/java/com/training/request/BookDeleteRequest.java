package com.training.request;

import com.training.bean.Book;

public class BookDeleteRequest {
	
	private int id;
	
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	

}

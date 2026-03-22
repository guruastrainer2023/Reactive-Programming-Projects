package com.training.service;

import java.util.List;

import com.training.bean.Book;

public interface BookService {

	Book addBook(Book book);

	Book updateBook(Book book);

	String deleteBook(int id);

	Book getBookById(int id);

	List<Book> getAllBooks();

}

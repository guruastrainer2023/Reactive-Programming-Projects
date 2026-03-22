package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bean.Book;
import com.training.dao.BookDAO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	
	

	public BookServiceImpl() {
		super();
		System.out.println("Book Service created");
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public Book addBook(Book book) {
		Book bk = this.bookDAO.save(book);
		return bk;
	}

	@Override
	public Book updateBook(Book book) {
		Book bk = this.bookDAO.save(book);
		return bk;
	}

	@Override
	public String deleteBook(int id) {
		this.bookDAO.deleteById(id);
		return "Book deleted Successfully!!!";

	}

	@Override
	public Book getBookById(int id) {
		Optional<Book> bookOptional = this.bookDAO.findById(id);
		if (bookOptional.isPresent()) {
			return bookOptional.get();
		} else
			return null;
	}

	@Override
	public List<Book> getAllBooks() {
		return this.bookDAO.findAll();
	}

}

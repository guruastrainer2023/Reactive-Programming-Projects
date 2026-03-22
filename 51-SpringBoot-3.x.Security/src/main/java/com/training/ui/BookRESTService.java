package com.training.ui;

import org.springframework.http.ResponseEntity;

import com.training.request.BookAddRequest;
import com.training.request.BookUpdateRequest;
import com.training.response.BookAddResponse;
import com.training.response.BookDeleteResponse;
import com.training.response.BookRetrieveAllResponse;
import com.training.response.BookRetrieveResponse;
import com.training.response.BookUpdateResponse;

public interface BookRESTService {

	ResponseEntity<BookAddResponse> addBook(BookAddRequest bookAddRequest);

	ResponseEntity<BookRetrieveResponse> getBookById(int id);

	ResponseEntity<BookRetrieveAllResponse> getAllBooks();

	ResponseEntity<BookUpdateResponse> updateBook(BookUpdateRequest bookUpdateRequest);

	ResponseEntity<BookDeleteResponse> deleteBookById(int id);

}

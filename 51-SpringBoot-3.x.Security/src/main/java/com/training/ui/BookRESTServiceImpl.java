package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Book;
import com.training.request.BookAddRequest;
import com.training.request.BookUpdateRequest;
import com.training.response.BookAddResponse;
import com.training.response.BookDeleteResponse;
import com.training.response.BookRetrieveAllResponse;
import com.training.response.BookRetrieveResponse;
import com.training.response.BookUpdateResponse;
import com.training.service.BookService;

@RestController
@RequestMapping("/books")
public class BookRESTServiceImpl implements BookRESTService {

	@Autowired
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<BookAddResponse> addBook(@RequestBody BookAddRequest bookAddRequest) {

		BookAddResponse response = new BookAddResponse();

		Book book1 = bookAddRequest.getBook();
		Book book2 = this.bookService.addBook(book1);

		response.setStatusCode(200);
		response.setBook(book2);
		response.setDescription("Book Added Successfully");
		return ResponseEntity.ok(response);
	}

	@Override
	@GetMapping("/find/{bid}")
	public ResponseEntity<BookRetrieveResponse> getBookById(@PathVariable(name = "bid") int id) {

		BookRetrieveResponse bookRetrieveResponse = new BookRetrieveResponse();
		Book book = this.bookService.getBookById(id);
		if (book != null) {
			bookRetrieveResponse.setStatusCode(200);
			bookRetrieveResponse.setDescription("Book Retrieved Successfully!!!");
			bookRetrieveResponse.setBook(book);
		} else {
			bookRetrieveResponse.setStatusCode(404);
			bookRetrieveResponse.setDescription("Book Not Retrieved");
			bookRetrieveResponse.setBook(null);
		}
		return ResponseEntity.ok(bookRetrieveResponse);
	}

	@Override
	@GetMapping("/all")
	public ResponseEntity<BookRetrieveAllResponse> getAllBooks() {
		BookRetrieveAllResponse response = new BookRetrieveAllResponse();

		List<Book> allBooks = this.bookService.getAllBooks();
		response.setStatusCode(200);
		response.setDesciption("All Books Retrieved Successfully!!!");
		response.setAllBooks(allBooks);
		return ResponseEntity.ok(response);
	}

	@Override
	@PutMapping("/update")
	public ResponseEntity<BookUpdateResponse> updateBook(@RequestBody BookUpdateRequest bookUpdateRequest) {
		BookUpdateResponse response = new BookUpdateResponse();

		Book book = bookUpdateRequest.getBook();

		Book resultBook = this.bookService.updateBook(book);

		response.setStatusCode(200);
		response.setDescription("Book Updated Successfully!!!");
		response.setBook(resultBook);
		return ResponseEntity.ok(response);
	}

	@Override
	@DeleteMapping("/deleteById/{bid}")
	public ResponseEntity<BookDeleteResponse> deleteBookById(@PathVariable(name = "bid") int id) {
		BookDeleteResponse bookDeleteResponse = new BookDeleteResponse();

		this.bookService.deleteBook(id);
		bookDeleteResponse.setStatusCode(200);
		bookDeleteResponse.setDescription("Book Deleted");
		return ResponseEntity.ok(bookDeleteResponse);
	}

}

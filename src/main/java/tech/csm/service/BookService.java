package tech.csm.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import tech.csm.model.Book;

public interface BookService {
	Book saveBook(Book b);
	Long noOfBooks();
	List<Book> getAllBooks(Pageable page);
	Book findBookById(Integer bId);
}

package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import tech.csm.model.Book;
import tech.csm.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	  @Autowired
	private BookRepository bookRepository;
	
	
	@Override
	public Book saveBook(Book b) {
		
		return bookRepository.save(b);
		
	}


	@Override
	public List<Book> getAllBooks(Pageable page) {
		return bookRepository.findByIsDeleted("NO", page);
	}


	@Override
	public Long noOfBooks() {
		
		return bookRepository.countActiveBooks();
	}


	@Override
	public Book findBookById(Integer bId) {
		return bookRepository.findById(bId).get();
		
	}

}

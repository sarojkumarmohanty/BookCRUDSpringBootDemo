package tech.csm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tech.csm.model.Book;
import tech.csm.service.BookService;
import tech.csm.util.FileUploadUtil;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/bookEntryForm")
	public String getBookEntryForm(Model model, @RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo) {
		Pageable page=null;
		if(pageNo !=null)
			page=PageRequest.of(pageNo, 2);
		model.addAttribute("bookList", bookService.getAllBooks(page));
		model.addAttribute("total",bookService.noOfBooks());
		return "book_entry_form";

	}

	@RequestMapping("/saveBook")
	public String saveBook(@RequestParam(name = "title") String title,
			@RequestParam(name = "bookId", required = false) Integer bookId,
			@RequestParam(name = "bookImagePath") MultipartFile bookImage,
			@RequestParam(name = "authorName") String authorName, @RequestParam(name = "publisherId") Integer publisher,
			@RequestParam(name = "publicationDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date publicationDate,
			@RequestParam(name = "price") Double price, RedirectAttributes rd

	) {
			
		
		System.out.println("++++++++++"+bookImage.isEmpty());
		
		Book b = new Book();
		
		b.setTitle(title);
		b.setBookImagePath(FileUploadUtil.getFilePath(bookImage));
		b.setAuthorName(authorName);
		b.setPublisherId(publisher);
		b.setPublicationDate(publicationDate);
		b.setPrice(price);
		b.setIsDeleted("NO");
		if(bookId != null) {
			b.setBookId(bookId);
			if(bookImage.isEmpty())
				b.setBookImagePath(bookService.findBookById(bookId).getBookImagePath());
		}
		System.out.println(b);		
		Book book=bookService.saveBook(b);		
		rd.addFlashAttribute("book", book);			
		return "redirect:/bookEntryForm";
	}
	
	@RequestMapping(path="/updateBook")
	public String updateBook(@RequestParam("bookId") Integer bId,Model model) {
		
		Book b=bookService.findBookById(bId);
		model.addAttribute("uBook", b);
		return "forward:/bookEntryForm";
		
	}

}

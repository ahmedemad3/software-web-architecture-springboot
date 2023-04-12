package com.eg.swa.SOA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eg.swa.SOA.model.Book;
import com.eg.swa.SOA.service.BookSearchService;
import com.eg.swa.SOA.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private final BookService bookService;
    private final BookSearchService bookSearchService;


	public BookController(BookService bookService , BookSearchService bookSearchService) {
		this.bookService = bookService;
		this.bookSearchService = bookSearchService;
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Optional<Book> book = bookService.getBookById(id);

		if (book.isPresent()) {
			return ResponseEntity.ok(book.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book savedBook = bookService.saveBook(book);
		return ResponseEntity.ok(savedBook);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") Long id) throws Exception {
		bookService.deleteBook(id);
	}
	
	@GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam("q") String searchTerm) {
        List<Book> books = bookSearchService.searchBooks(searchTerm);
        return ResponseEntity.ok(books);
    }
}

package com.eg.swa.redis.cache.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.swa.redis.cache.model.Book;
import com.eg.swa.redis.cache.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByName(@PathVariable("title") String title) {
        Optional<Book> book = bookService.findByTitle(title);
        if (!book.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book.get());
    }
}


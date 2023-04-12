package com.eg.swa.redis.cache.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eg.swa.redis.cache.model.Book;
import com.eg.swa.redis.cache.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}


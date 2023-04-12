package com.eg.swa.SOA.service;

import java.util.List;

import com.eg.swa.SOA.model.Book;

public interface BookSearchService {
    List<Book> searchBooks(String searchTerm);
}


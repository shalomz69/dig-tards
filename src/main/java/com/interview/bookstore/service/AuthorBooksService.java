package com.interview.bookstore.service;

import com.interview.bookstore.service.dto.ReviewDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorBooksService {
    String publisherName();
    ResponseEntity<List<ReviewDTO>> fetchBooks(String author);
}

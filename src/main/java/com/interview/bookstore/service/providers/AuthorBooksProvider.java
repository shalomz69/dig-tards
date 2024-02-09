package com.interview.bookstore.service.providers;

import com.interview.bookstore.service.AuthorBooksService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthorBooksProvider {
    private final Set<AuthorBooksService> authorBooks;

    public AuthorBooksProvider(Set<AuthorBooksService> authorBooks) {
        this.authorBooks = authorBooks;
    }

    public AuthorBooksService provide(String publisher) {
        return authorBooks.stream().filter(authorBooks -> authorBooks.publisherName().equals(publisher))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No publisher found for publisher: " + publisher));
    }
}

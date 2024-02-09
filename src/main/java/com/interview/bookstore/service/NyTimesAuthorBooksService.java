package com.interview.bookstore.service;


import com.interview.bookstore.service.dto.ReviewDTO;
import com.interview.bookstore.service.dto.ReviewResultsDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NyTimesAuthorBooksService implements AuthorBooksService {
    private static final String URI = "https://api.nytimes.com/svc/books/v3/reviews.json";
    private static final String API_KEY = "heAhyfisnHARlWMVPIHgSgzpr8UhsHXZ"; //should be saved in env

    private final RestTemplate restTemplate;

    public NyTimesAuthorBooksService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String publisherName() {
        return "NY_TIMES";
    }

    public ResponseEntity<List<ReviewDTO>> fetchBooks(String author){
        final String apiUrl = URI + "?author=" + author + "&api-key=" + API_KEY;
        final ResponseEntity<ReviewResultsDTO> response =  restTemplate.exchange(
            apiUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<ReviewResultsDTO>() {});
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            List<ReviewDTO> reviews = response.getBody().getResults();
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response.getStatusCode());
        }
    }
}

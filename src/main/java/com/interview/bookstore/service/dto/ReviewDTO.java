package com.interview.bookstore.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewDTO {
    @JsonProperty("summary")
    private String summary;

    @JsonProperty("book_title")
    private String bookTitle;

    public String getSummary() {
        return summary;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}


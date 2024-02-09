package com.interview.bookstore.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewResultsDTO {
    @JsonProperty("results")
    private List<ReviewDTO> results;

    public List<ReviewDTO> getResults() {
        return results;
    }
}

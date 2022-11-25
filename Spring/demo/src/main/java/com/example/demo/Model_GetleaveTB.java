package com.example.demo;
import org.springframework.stereotype.Component;

@Component
public class Model_GetleaveTB {
    private String year;
    private String review;
    
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    
}

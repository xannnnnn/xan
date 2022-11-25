package com.example.demo;
import org.springframework.stereotype.Component;

@Component
public class Model_verify {
    private String index;
    private String review;
    private String review_reason;

    public String getReview_reason() {
        return review_reason;
    }
    public void setReview_reason(String review_reason) {
        this.review_reason = review_reason;
    }
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    
}

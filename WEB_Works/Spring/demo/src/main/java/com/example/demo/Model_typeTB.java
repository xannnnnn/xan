package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Model_typeTB {
    private String index;
    private String type;
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}

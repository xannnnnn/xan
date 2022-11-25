package com.example.demo;
import org.springframework.stereotype.Component;

@Component
public class Model_JobAgent {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

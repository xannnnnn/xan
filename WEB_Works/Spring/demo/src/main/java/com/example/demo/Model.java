package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Model {
    
    private String user;
    private String pwd;
    
    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
}


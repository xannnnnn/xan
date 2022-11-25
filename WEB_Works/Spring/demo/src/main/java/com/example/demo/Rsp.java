package com.example.demo;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class Rsp {
    private String msg;
    private Map data;
    private String data_str;
    private Integer code;

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Map getData() {
        return data;
    }
    public void setData(Map data) {
        this.data = data;
    }
    public String getData_str() {
        return data_str;
    }
    public void setData_str(String data_str) {
        this.data_str = data_str;
    }
    
}

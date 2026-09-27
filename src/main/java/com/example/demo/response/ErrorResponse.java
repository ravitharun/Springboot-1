package com.example.demo.response;

public class ErrorResponse {

    private int code;
    private String message;

    // Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getters
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
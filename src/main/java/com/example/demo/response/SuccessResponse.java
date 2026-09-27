package com.example.demo.response;

import com.example.demo.model.UserModel;

public class SuccessResponse {

    private int code;
    private String message;
    private UserDto data;

    // Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(UserDto data) {
        this.data = data;
    }

    // Getters
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    public UserDto getData() {
        return data;
    }


}
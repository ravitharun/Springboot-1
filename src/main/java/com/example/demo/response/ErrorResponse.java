package com.example.demo.response;

import java.util.Date;

public class ErrorResponse {

    private int code;
    private String message;
    
    private Date date;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return new Date();
	}

	public void setDate(String date) {
		this.date = new Date();
	}

   

}
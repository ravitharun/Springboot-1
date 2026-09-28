package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.demo.exception.UserAge;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.response.ErrorResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Valid validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationError(
            MethodArgumentNotValidException e) {

        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        response.put("code", 400);
        response.put("message", "Validation failed");
        response.put("errors", errors);

        return ResponseEntity.status(400).body(response);
    }

    // Missing @RequestParam
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleMissingParameter(
            MissingServletRequestParameterException e) {

        Map<String, Object> response = new HashMap<>();

        response.put("code", 400);
        response.put("message", e.getParameterName() + " parameter is required");

        return ResponseEntity.status(400).body(response);
    }

    // Wrong @RequestParam type
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleTypeMismatch(
            MethodArgumentTypeMismatchException e) {

        Map<String, Object> response = new HashMap<>();

        response.put("code", 400);
        response.put("message", "Invalid value for parameter: " + e.getName());

        return ResponseEntity.status(400).body(response);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleUserNotFound(UserNotFoundException ex) {

        ErrorResponse response = new ErrorResponse();

        response.setCode(404);
        response.setMessage(ex.getMessage());

        return ResponseEntity.status(response.getCode()).body(response);
    }
    
    @ExceptionHandler(UserAge.class)
    
    public ResponseEntity<ErrorResponse> handelUserAge(UserAge userage) {
    	ErrorResponse err=new ErrorResponse(); 
    	err.setCode(400);
    	err.setMessage("user id not found");
    	return ResponseEntity.status(400).body(err);
    	
    }
    
}
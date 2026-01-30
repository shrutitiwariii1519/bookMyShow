package com.example.bookMyShowDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SeatUnavailableException.class)
    public ResponseEntity<Map<String, String>> handleSeatUnavailable(SeatUnavailableException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Seat Unavailable");
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(ShowNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleShowNotFound(ShowNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Show Not Found");
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneric(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Internal Server Error");
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
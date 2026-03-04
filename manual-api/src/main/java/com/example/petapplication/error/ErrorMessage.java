package com.example.petapplication.error;

import java.time.LocalDateTime;

public class ErrorMessage {
    private LocalDateTime timestamp;
    private String message;
    private int statusCode;


    public ErrorMessage(String message, int statusCode) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.statusCode = statusCode;
    }


    public LocalDateTime getTimestamp() { return timestamp; }
    public String getMessage() { return message; }
    public int getStatusCode() { return statusCode; }
}

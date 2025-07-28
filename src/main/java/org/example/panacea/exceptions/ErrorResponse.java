package org.example.panacea.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private String errorCode;

    public ErrorResponse(int value, String message, LocalDateTime now) {
    }

    // Constructor and getters/setters
}
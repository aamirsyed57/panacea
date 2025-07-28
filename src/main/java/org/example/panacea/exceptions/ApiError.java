package org.example.panacea.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private int code;
    private String message;
    private String detail;
    private LocalDateTime timestamp;

    public ApiError(int code, String message, String detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
        this.timestamp = LocalDateTime.now();
    }
}
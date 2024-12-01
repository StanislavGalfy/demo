package com.example.demo.exception;

import com.example.demo.model.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final String errorCode;

    private ApiException(String message, HttpStatus httpStatus, String errorCode) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public static ApiException demoNotFound(Long demoId) {
        return new ApiException("Demo with ID '" + demoId + "' was not found", HttpStatus.NOT_FOUND,
                ErrorCode.DEMO_NOT_FOUND);
    }
}

package com.example.koschool.global.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ErrorResponse {
    private String status;
    private String message;

    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode e){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ErrorResponse.builder()
                .status(e.name())
                .message(e.getMessage())
                .build()
            );
    }
}

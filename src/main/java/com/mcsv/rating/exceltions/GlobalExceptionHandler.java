package com.mcsv.rating.exceltions;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import com.mcsv.rating.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.LocalTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e){
        ApiResponse response = ApiResponse.builder()
                .message(e.getMessage())
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.builder().build());
    }
}

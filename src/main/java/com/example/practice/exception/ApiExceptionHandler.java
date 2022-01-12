package com.example.practice.exception;

import jdk.jshell.spi.SPIResolutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<ApiException> handlerApiException(SPIResolutionException e){
        // 1. Create payload cotaining exception details
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("z"))
        );

        // 2. Return Response
        return new ResponseEntity<ApiException>(apiException, HttpStatus.BAD_REQUEST);

    }
}

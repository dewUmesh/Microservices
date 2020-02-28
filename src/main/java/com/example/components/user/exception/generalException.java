package com.example.components.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class generalException {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity handle(Exception ex, WebRequest wb) {

        //return ResponseEntity.created(location).header("MyResponseHeader", "MyValue").body("Hello World");
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }
}

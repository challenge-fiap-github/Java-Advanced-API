package com.odontovision.Java_API.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DentistaNotFoundException.class)
    public ResponseEntity<String> handleNotFound(DentistaNotFoundException ex) {
        return ResponseEntity
                .status(404)
                .body(ex.getMessage());
    }
}
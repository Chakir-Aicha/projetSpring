package com.example.diagnostique.projetdiagnostique.controllers;

import com.example.diagnostique.projetdiagnostique.models.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomError> handleIllegalArgumentException(IllegalArgumentException ex) {
        CustomError errorResponse = new CustomError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

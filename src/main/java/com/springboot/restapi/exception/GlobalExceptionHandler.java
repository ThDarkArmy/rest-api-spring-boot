package com.springboot.restapi.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception){
        return status(HttpStatus.NOT_FOUND).body(exception.getLocalizedMessage());
    }

    @ExceptionHandler({BindException.class})
    public ResponseEntity<?> handleBindException(BindException exception, HttpServletRequest request){
        var error = exception.getBindingResult().getAllErrors()
                .stream()
                .map(exc->
                        new BeanValidationException(Objects.requireNonNull(exc.getCodes())[1] , exc.getDefaultMessage())
                )
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Binding Error", error));
    }
}

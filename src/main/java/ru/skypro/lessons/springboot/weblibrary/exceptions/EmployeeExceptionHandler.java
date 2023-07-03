package ru.skypro.lessons.springboot.weblibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleNotFound(EmployeeNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(EmployeeNotValidException.class)
    public ResponseEntity<?> handleNotFound(EmployeeNotValidException e) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}

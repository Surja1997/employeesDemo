package com.dazzler.employees.Advice;

import com.dazzler.employees.exceptions.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){

        return new ResponseEntity<String>("Input field is empty, please give non empty values", HttpStatus.BAD_REQUEST);
    }

}

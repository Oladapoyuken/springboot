package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException pnfe){
        return new ResponseEntity<>("Product not Found", HttpStatus.OK);
    }


    @ExceptionHandler(value = UnauthorizedAccessException.class)
    public ResponseEntity<Object> exception_one(UnauthorizedAccessException uae){
        return new ResponseEntity<>("Sorry, product doesn't exist", HttpStatus.OK);
    }

}

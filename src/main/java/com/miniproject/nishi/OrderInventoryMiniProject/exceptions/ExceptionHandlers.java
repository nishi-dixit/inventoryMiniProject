package com.miniproject.nishi.OrderInventoryMiniProject.exceptions;

import com.miniproject.nishi.OrderInventoryMiniProject.model.outbound.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlers{

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"0xfffff1",exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InventoryNotAvailableException.class)
    public ResponseEntity<Object> exceptionInventory(InventoryNotAvailableException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"0xfffff1",exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ProductAlreadyExists.class)
    public ResponseEntity<Object> exceptionProductAlreadyExists(ProductAlreadyExists exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"0xfffff1",exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}

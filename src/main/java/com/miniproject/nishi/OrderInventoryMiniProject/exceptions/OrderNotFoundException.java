package com.miniproject.nishi.OrderInventoryMiniProject.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String message) {
        super(message);
    }
}

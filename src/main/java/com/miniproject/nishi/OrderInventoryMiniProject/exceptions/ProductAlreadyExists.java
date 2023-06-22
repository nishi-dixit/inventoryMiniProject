package com.miniproject.nishi.OrderInventoryMiniProject.exceptions;

public class ProductAlreadyExists extends RuntimeException{
    public ProductAlreadyExists(String message) {
        super(message);
    }
}

package com.miniproject.nishi.OrderInventoryMiniProject.exceptions;

public class InventoryNotAvailableException extends RuntimeException{
    public InventoryNotAvailableException(String message) {
        super(message);
    }
}

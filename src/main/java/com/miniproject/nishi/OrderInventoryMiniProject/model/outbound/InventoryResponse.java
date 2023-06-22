package com.miniproject.nishi.OrderInventoryMiniProject.model.outbound;

import com.miniproject.nishi.OrderInventoryMiniProject.model.Product;

import java.io.Serializable;

public class InventoryResponse implements Serializable {
    private String productId;

    private String message;
    private Product productDetails;
    private Integer qty;

    public InventoryResponse() {
    }

    public InventoryResponse(String productId, String message, Product productDetails, Integer qty) {
        this.productId = productId;
        this.message = message;
        this.productDetails = productDetails;
        this.qty = qty;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Product productDetails) {
        this.productDetails = productDetails;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}

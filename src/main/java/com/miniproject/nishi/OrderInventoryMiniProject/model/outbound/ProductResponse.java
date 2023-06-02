package com.miniproject.nishi.OrderInventoryMiniProject.model.outbound;

import java.io.Serializable;

public class ProductResponse implements Serializable {

    private String productId;
    private String productDescription;
    private String uom;
    private Integer price;
    private String message;

    public ProductResponse() {
    }

    public ProductResponse(String productId, String productDescription, String uom, Integer price, String message) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.uom = uom;
        this.price = price;
        this.message = message;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

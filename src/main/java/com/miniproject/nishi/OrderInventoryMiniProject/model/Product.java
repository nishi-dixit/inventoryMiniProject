package com.miniproject.nishi.OrderInventoryMiniProject.model;


import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String productId;
    private String productDescription;
    private String uom;
    private Integer price;

    public Product() {
    }

    public Product(String productId, String productDescription, String uom, Integer price) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.uom = uom;
        this.price = price;
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
}

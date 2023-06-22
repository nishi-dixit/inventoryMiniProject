package com.miniproject.nishi.OrderInventoryMiniProject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Inventory")
@Data
public class Inventory {
    @Id
    private String id;
    private Product productDetails;
    private Integer qty;


    public Inventory(String id,Product productDetails, Integer qty) {
        this.id = id;
        this.productDetails = productDetails;
        this.qty = qty;
    }
    public Inventory(Product productDetails, Integer qty) {
        this.productDetails = productDetails;
        this.qty = qty;
    }

    public Inventory() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

package com.miniproject.nishi.OrderInventoryMiniProject.model.inbound;


import lombok.Data;

@Data
public class InventoryDto {
    private String productId;
    private String productDescription;
    private String uom;
    private Integer price;
    private Integer qty;

    public InventoryDto(String productId, String productDescription, String uom, Integer price, Integer qty) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.uom = uom;
        this.price = price;
        this.qty = qty;
    }

    public InventoryDto() {
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}

package com.miniproject.nishi.OrderInventoryMiniProject.model;

import com.miniproject.nishi.OrderInventoryMiniProject.model.inbound.InventoryDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "Orders")
@Data
public class Order {

    @Id
    private String orderId;

    private String orderCreatedate;

    private ORDERTYPE orderType;

    private Customer customerDetails;

    private List<InventoryDto> orderDetails;

    private Double orderValue;

    public Order(String orderId, String orderCreatedate, ORDERTYPE orderType, Customer customerDetails, List<InventoryDto> orderDetails, Double orderValue) {
        this.orderId = orderId;
        this.orderCreatedate = orderCreatedate;
        this.orderType = orderType;
        this.customerDetails = customerDetails;
        this.orderDetails = orderDetails;
        this.orderValue = orderValue;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCreatedate() {
        return orderCreatedate;
    }

    public void setOrderCreatedate(String orderCreatedate) {
        this.orderCreatedate = orderCreatedate;
    }

    public ORDERTYPE getOrderType() {
        return orderType;
    }

    public void setOrderType(ORDERTYPE orderType) {
        this.orderType = orderType;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    public List<InventoryDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<InventoryDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public Order() {
    }



}

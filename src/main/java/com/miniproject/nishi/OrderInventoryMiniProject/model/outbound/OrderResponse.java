package com.miniproject.nishi.OrderInventoryMiniProject.model.outbound;

import com.miniproject.nishi.OrderInventoryMiniProject.model.Customer;
import com.miniproject.nishi.OrderInventoryMiniProject.model.Inventory;
import com.miniproject.nishi.OrderInventoryMiniProject.model.ORDERTYPE;
import com.miniproject.nishi.OrderInventoryMiniProject.model.inbound.InventoryDto;

import java.util.List;

public class OrderResponse {

    private String orderId;

    private String orderCreatedate;

    private String message;

    private ORDERTYPE orderType;

    private Customer customerDetails;

    private List<InventoryDto> orderDetails;

    private Double orderValue;

    public OrderResponse(String orderId, String orderCreatedate, String message, ORDERTYPE orderType, Customer customerDetails, List<InventoryDto> orderDetails, Double orderValue) {
        this.orderId = orderId;
        this.orderCreatedate = orderCreatedate;
        this.message = message;
        this.orderType = orderType;
        this.customerDetails = customerDetails;
        this.orderDetails = orderDetails;
        this.orderValue = orderValue;
    }

    public OrderResponse() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}

package com.miniproject.nishi.OrderInventoryMiniProject.model.inbound;

import com.miniproject.nishi.OrderInventoryMiniProject.model.Customer;
import com.miniproject.nishi.OrderInventoryMiniProject.model.Inventory;
import com.miniproject.nishi.OrderInventoryMiniProject.model.ORDERTYPE;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
public class OrderDto {
    private String orderId;

    private ORDERTYPE orderType;

    private Customer customerDetails;

    private List<InventoryDto> orderDetails;


    public OrderDto(String orderId, ORDERTYPE orderType, Customer customerDetails, List<InventoryDto> orderDetails) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.customerDetails = customerDetails;
        this.orderDetails = orderDetails;
    }

    public OrderDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

}

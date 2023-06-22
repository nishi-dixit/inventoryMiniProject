package com.miniproject.nishi.OrderInventoryMiniProject.repository;

import com.miniproject.nishi.OrderInventoryMiniProject.model.Order;
import com.miniproject.nishi.OrderInventoryMiniProject.model.inbound.OrderDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order,String> {
}

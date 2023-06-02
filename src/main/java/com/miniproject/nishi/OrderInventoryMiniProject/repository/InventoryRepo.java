package com.miniproject.nishi.OrderInventoryMiniProject.repository;

import com.miniproject.nishi.OrderInventoryMiniProject.model.Inventory;
import com.miniproject.nishi.OrderInventoryMiniProject.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InventoryRepo extends MongoRepository<Inventory,String>{
    public Optional<Inventory> findByProductDetails_ProductId(String id);
}

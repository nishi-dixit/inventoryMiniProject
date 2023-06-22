package com.miniproject.nishi.OrderInventoryMiniProject.repository;

import com.miniproject.nishi.OrderInventoryMiniProject.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product,String> {

}

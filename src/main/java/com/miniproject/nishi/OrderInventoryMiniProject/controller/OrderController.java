package com.miniproject.nishi.OrderInventoryMiniProject.controller;

import com.miniproject.nishi.OrderInventoryMiniProject.model.Order;
import com.miniproject.nishi.OrderInventoryMiniProject.model.Product;
import com.miniproject.nishi.OrderInventoryMiniProject.model.inbound.OrderDto;
import com.miniproject.nishi.OrderInventoryMiniProject.service.InventoryOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private InventoryOperations inventoryOperations;

    @PostMapping("product/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(inventoryOperations.createProduct(product));
    }

    @PutMapping("product/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(inventoryOperations.updateProduct(product));
    }

    @GetMapping("product/getProduct/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable String productId){
        return ResponseEntity.ok().body(inventoryOperations.getProduct(productId));
    }

    @DeleteMapping("product/delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
        return ResponseEntity.ok().body(inventoryOperations.deleteProduct(productId));
    }

    @PostMapping("order/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto order){

        //create a replica order DTO
        //
        return ResponseEntity.ok().body(inventoryOperations.placeOrder(order));
    }

    @GetMapping("order/getOrder/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable String orderId){
        return ResponseEntity.ok().body(inventoryOperations.getOrder(orderId));
    }

    @GetMapping("inventory/getQty/{productId}")
    public ResponseEntity<?> getInventory(@PathVariable String productId){
        return ResponseEntity.ok().body(inventoryOperations.getInventory(productId));
    }





}

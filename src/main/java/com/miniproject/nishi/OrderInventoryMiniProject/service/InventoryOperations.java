package com.miniproject.nishi.OrderInventoryMiniProject.service;

import com.miniproject.nishi.OrderInventoryMiniProject.exceptions.*;
import com.miniproject.nishi.OrderInventoryMiniProject.model.Inventory;
import com.miniproject.nishi.OrderInventoryMiniProject.model.Order;
import com.miniproject.nishi.OrderInventoryMiniProject.model.Product;
import com.miniproject.nishi.OrderInventoryMiniProject.model.inbound.InventoryDto;
import com.miniproject.nishi.OrderInventoryMiniProject.model.inbound.OrderDto;
import com.miniproject.nishi.OrderInventoryMiniProject.model.outbound.InventoryResponse;
import com.miniproject.nishi.OrderInventoryMiniProject.model.outbound.OrderResponse;
import com.miniproject.nishi.OrderInventoryMiniProject.model.outbound.ProductResponse;
import com.miniproject.nishi.OrderInventoryMiniProject.repository.InventoryRepo;
import com.miniproject.nishi.OrderInventoryMiniProject.repository.OrderRepo;
import com.miniproject.nishi.OrderInventoryMiniProject.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.miniproject.nishi.OrderInventoryMiniProject.model.ORDERTYPE.PURCHASEORDER;
import static com.miniproject.nishi.OrderInventoryMiniProject.model.ORDERTYPE.SALEORDER;

@Service
public class InventoryOperations {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");



    public OrderResponse placeOrder(OrderDto order) {
        if (order.getOrderType().equals(PURCHASEORDER)) {
            // We need to update the inventory for each item
            List<InventoryDto> inventoryDtoList = order.getOrderDetails();
            Double orderValue = 0.0;
            for(int i = 0; i<inventoryDtoList.size();i++){
                String productId = inventoryDtoList.get(i).getProductId();
                //find whether the product exists in the inventory repo or not
                Optional<Inventory> productIdFromInv = inventoryRepo.findByProductDetails_ProductId(productId);
                if (productIdFromInv.isPresent()){
                    Integer initialQty = productIdFromInv.get().getQty();
                    Integer finalQty = initialQty + (inventoryDtoList.get(i).getQty());
                    productIdFromInv.get().setQty(finalQty);
                    inventoryRepo.save(productIdFromInv.get());
                    Integer currentQty = inventoryDtoList.get(i).getQty();
                    Integer currentPrice = inventoryDtoList.get(i).getPrice();
                    orderValue+=(currentPrice*currentQty);
                }
                else{
                    throw new ProductNotFoundException("Product " + productId + " Not Found");
                }
            }
            Order newOrder = new Order();
            newOrder.setOrderCreatedate(sdf.format(new Date()));
            newOrder.setOrderValue(orderValue);
            newOrder.setOrderId(order.getOrderId());
            newOrder.setOrderDetails(order.getOrderDetails());
            newOrder.setOrderType(order.getOrderType());
            newOrder.setCustomerDetails(order.getCustomerDetails());
            orderRepo.save(newOrder);

            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setOrderId(order.getOrderId());
            orderResponse.setOrderDetails(order.getOrderDetails());
            orderResponse.setOrderType(order.getOrderType());
            orderResponse.setOrderCreatedate(newOrder.getOrderCreatedate());
            orderResponse.setCustomerDetails(order.getCustomerDetails());
            orderResponse.setMessage("Purchase Order Placed Successfully");
            orderResponse.setOrderValue(orderValue);
            return orderResponse;
        }
        else if (order.getOrderType().equals(SALEORDER)) {
            List<InventoryDto> inventoryDtoList = order.getOrderDetails();
            Double orderValue = 0.0;
            for(int i = 0; i<inventoryDtoList.size();i++){
                String productId = inventoryDtoList.get(i).getProductId();
                //find whether the product exists in the inventory repo or not
                Optional<Inventory> productIdFromInv = inventoryRepo.findByProductDetails_ProductId(productId);
                if (productIdFromInv.isPresent()){
                    Integer initialQty = productIdFromInv.get().getQty();
                    Integer finalQty = initialQty - (inventoryDtoList.get(i).getQty());
                    productIdFromInv.get().setQty(finalQty);
                    inventoryRepo.save(productIdFromInv.get());
                    Integer currentQty = inventoryDtoList.get(i).getQty();
                    Integer currentPrice = inventoryDtoList.get(i).getPrice();
                    orderValue+=(currentPrice*currentQty);
                }
                else{
                    throw new ProductNotFoundException("Product " + productId + " Not Found");
                }
            }
            Order newOrder = new Order();
            newOrder.setOrderCreatedate(sdf.format(new Date()));
            newOrder.setOrderValue(orderValue);
            newOrder.setOrderId(order.getOrderId());
            newOrder.setOrderDetails(order.getOrderDetails());
            newOrder.setOrderType(order.getOrderType());
            newOrder.setCustomerDetails(order.getCustomerDetails());
            orderRepo.save(newOrder);

            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setOrderId(order.getOrderId());
            orderResponse.setOrderDetails(order.getOrderDetails());
            orderResponse.setOrderType(order.getOrderType());
            orderResponse.setOrderCreatedate(newOrder.getOrderCreatedate());
            orderResponse.setCustomerDetails(order.getCustomerDetails());
            orderResponse.setMessage("Sale Order Placed Successfully");
            return orderResponse;
        }
        throw new InvalidOrderType("Invalid Order Type");
    }

    // Get Specific order based on Id
    public OrderResponse getOrder(String orderId) {
        if (orderRepo.findById(orderId).isPresent()) {
            Order order = orderRepo.findById(orderId).get();
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setOrderId(order.getOrderId());
            orderResponse.setOrderDetails(order.getOrderDetails());
            orderResponse.setOrderType(order.getOrderType());
            orderResponse.setOrderCreatedate(order.getOrderCreatedate());
            orderResponse.setCustomerDetails(order.getCustomerDetails());
            orderResponse.setMessage("Order Reterived Successfully");
            orderResponse.setOrderValue(order.getOrderValue());
            return orderResponse;
        }
        throw new OrderNotFoundException("Order with "+orderId+" does not exist");
    }

    //Get inventory picture
    public InventoryResponse getInventory(String productId) {
        Optional<Inventory> inventory = inventoryRepo.findByProductDetails_ProductId(productId);
        if (inventory.isPresent()) {
            InventoryResponse inventoryResponse = new InventoryResponse();
            inventoryResponse.setProductId(productId);
            inventoryResponse.setProductDetails(inventory.get().getProductDetails());
            inventoryResponse.setQty(inventory.get().getQty());
            inventoryResponse.setMessage("Product Inventory Fetched Successfully");

            return inventoryResponse;
        }
        throw new ProductNotFoundException("Product " + productId + " Not Found");
    }

    // Create New product
    public ProductResponse createProduct(Product product) {
        if (productRepo.findById(product.getProductId()).isPresent()) {
            throw new ProductAlreadyExists("Product "+product.getProductId()+" Already Exists");
        }
        productRepo.save(product);
        Inventory inventory = new Inventory(product, 0);
        inventoryRepo.save(inventory);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductDescription(product.getProductDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setMessage("Product Created Successfully");
        productResponse.setUom(product.getUom());
        productResponse.setProductId(product.getProductId());
        return productResponse;
    }

    // update Product
    public ProductResponse updateProduct(Product product) {
        Product newProduct = productRepo.findById(product.getProductId()).get();
        newProduct.setProductDescription(product.getProductDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setProductId(product.getProductId());
        newProduct.setUom(product.getUom());

        //Generating custom response
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductDescription(product.getProductDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setMessage("Product Updated Successfully");
        productResponse.setUom(product.getUom());
        productResponse.setProductId(product.getProductId());
        productRepo.save(newProduct);
        return productResponse;
    }

    // Delete Product
    public ProductResponse deleteProduct(String productId) {
        if (productRepo.findById(productId).isPresent()) {
            Inventory inventory = inventoryRepo.findByProductDetails_ProductId(productId).get();
            inventoryRepo.deleteById(inventory.getId());
            Product productToBeDeleted = productRepo.findById(productId).get();
            productRepo.deleteById(productId);
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductDescription(productToBeDeleted.getProductDescription());
            productResponse.setPrice(productToBeDeleted.getPrice());
            productResponse.setMessage("Product Deleted Successfully");
            productResponse.setUom(productToBeDeleted.getUom());
            productResponse.setProductId(productToBeDeleted.getProductId());
            return productResponse;
        }
        throw new ProductNotFoundException("Product " + productId + " Not Found");
    }


    public ProductResponse getProduct(String productId) {
        if (productRepo.findById(productId).isPresent()) {
            Product product = productRepo.findById(productId).get();
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductDescription(product.getProductDescription());
            productResponse.setPrice(product.getPrice());
            productResponse.setMessage("Product Fetched Successfully");
            productResponse.setUom(product.getUom());
            productResponse.setProductId(product.getProductId());
            return productResponse;
        }
        throw new ProductNotFoundException("Product " + productId + " Not Found");
    }


}

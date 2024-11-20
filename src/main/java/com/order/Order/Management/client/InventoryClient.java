package com.order.Order.Management.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service", url = "http://localhost/api/products") // замініть URL на адресу Product Service
public interface ProductServiceClient {
    @GetMapping("/api/products/{productId}")
    ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId);
}

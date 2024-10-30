package com.order.Order.Management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class OrderItem {

    @Id
    private String id;
    private Long productId;
    private int quantity;
    private double price;
}
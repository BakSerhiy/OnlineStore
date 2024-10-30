package com.order.Order.Management.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private Long userId;
    private String status;
    private double totalAmount;
    private List<OrderItem> orderItems;
}
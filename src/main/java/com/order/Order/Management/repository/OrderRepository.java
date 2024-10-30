package com.order.Order.Management.repository;



import com.order.Order.Management.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
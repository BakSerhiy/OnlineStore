package com.order.Order.Management.controller;




import com.order.Order.Management.model.Order;
import com.order.Order.Management.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll(); // Очистка бази даних перед кожним тестом
    }

    @Test
    public void testCreateOrder() throws Exception {
        String orderJson = "{"
                + "\"userId\":\"12345\","
                + "\"status\":\"PENDING\","
                + "\"totalAmount\":150.75,"
                + "\"orderItems\":["
                + "{\"productId\":\"98765\", \"quantity\":2},"
                + "{\"productId\":\"12345\", \"quantity\":1}"
                + "]"
                + "}";

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    public void testGetOrderById() throws Exception {
        // Спочатку створимо замовлення
        Order order = new Order();
        order.setUserId(Long.valueOf("12345"));
        order.setStatus("PENDING");
        order.setTotalAmount(150.75);
        // Додайте свої orderItems тут...

        order = orderRepository.save(order);

        mockMvc.perform(get("/orders/{id}", order.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(order.getId()))
                .andExpect(jsonPath("$.status").value("PENDING"));
    }
}

package com.order.Order.Management;

import org.springframework.boot.SpringApplication;

public class TestOrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

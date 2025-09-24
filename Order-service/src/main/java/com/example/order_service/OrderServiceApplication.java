package com.example.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {

		SpringApplication app=new SpringApplication(OrderServiceApplication.class);
		app.setDefaultProperties(Map.of("server.port", "0"));
		app.run(args);
	}

}

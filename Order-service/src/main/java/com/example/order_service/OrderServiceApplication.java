package com.example.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApplication {

	public static void main(String[] args) {

		SpringApplication app=new SpringApplication(OrderServiceApplication.class);
		app.setDefaultProperties(Map.of("server.port", "3001"));
		app.run(args);
	}

}

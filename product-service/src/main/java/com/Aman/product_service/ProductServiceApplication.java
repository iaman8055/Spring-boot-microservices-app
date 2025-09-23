package com.Aman.product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProductServiceApplication.class);
		app.setDefaultProperties(Map.of("server.port", "3000"));
		app.run(args);	}

}

package com.example.inventory_service;

import com.example.inventory_service.Model.Inventory;
import com.example.inventory_service.Repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(InventoryServiceApplication.class);
		app.setDefaultProperties(Map.of("server.port", "3002"));
		app.run(args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory=new Inventory();
			inventory.setSkucode("Iphone-17");
			inventory.setQuantity(123);

			Inventory inventory1=new Inventory();
			inventory1.setSkucode("Laptop");
			inventory1.setQuantity(234);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}

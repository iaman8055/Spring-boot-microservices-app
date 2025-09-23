package com.example.inventory_service.Service;

import com.example.inventory_service.Repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {
    public final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    @Transactional(readOnly = true)
    public boolean isInStock(String skudcode){
        return inventoryRepository.findBySkucode(skudcode).isPresent();
    }
}

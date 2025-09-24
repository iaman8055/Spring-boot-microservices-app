package com.example.inventory_service.Service;

import com.example.inventory_service.Model.Inventory;
import com.example.inventory_service.Repository.InventoryRepository;
import com.example.inventory_service.dto.InventoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
    public final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skucode) {
        return inventoryRepository.findBySkucodeIn(skucode).stream()
                .map(inventory -> new InventoryResponse(
                        inventory.getSkucode(),
                        inventory.getQuantity() > 0
                ))
                .toList();

    }
}

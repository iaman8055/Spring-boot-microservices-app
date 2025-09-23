package com.example.inventory_service.Controller;


import com.example.inventory_service.Service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{skucode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("skucode") String skucode ){
       return inventoryService.isInStock(skucode);

    }

}

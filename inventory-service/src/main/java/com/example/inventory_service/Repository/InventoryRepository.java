package com.example.inventory_service.Repository;

import com.example.inventory_service.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findBySkucodeIn(List<String> skucode);
}

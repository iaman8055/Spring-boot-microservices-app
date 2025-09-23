package com.example.inventory_service.Model;


import jakarta.persistence.*;

@Entity
@Table(name="t_inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skucode;
    private Integer quantity;

    public Inventory() {
    }

    public Inventory(Long id, String skucode, Integer quantity) {
        this.id = id;
        this.skucode = skucode;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkucode() {
        return skucode;
    }

    public void setSkucode(String skucode) {
        this.skucode = skucode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

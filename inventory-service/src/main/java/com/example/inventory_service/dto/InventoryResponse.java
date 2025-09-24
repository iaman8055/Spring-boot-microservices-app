package com.example.inventory_service.dto;



public class InventoryResponse {

    private String skucode;
    private boolean isInStock;


    public InventoryResponse(String skucode, boolean isInStock) {
        this.skucode = skucode;
        this.isInStock = isInStock;
    }

    public String getSkucode() {
        return skucode;
    }

    public boolean isInStock() {
        return isInStock;
    }
}

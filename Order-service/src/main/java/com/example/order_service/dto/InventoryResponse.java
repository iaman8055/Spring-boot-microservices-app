package com.example.order_service.dto;



public class InventoryResponse {

    private String skucode;
    private boolean inStock;


    public InventoryResponse(String skucode, boolean inStock) {
        this.skucode = skucode;
        this.inStock = inStock;
    }

    public String getSkucode() {
        return skucode;
    }

    public boolean inStock() {
        return inStock;
    }
}

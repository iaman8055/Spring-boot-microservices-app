package com.example.order_service.dto;





public class OrderLineItemsdto {
    private Long id;

    public OrderLineItemsdto() {
    }

    public OrderLineItemsdto(Long id, String skucode, String price, Integer quantity) {
        this.id = id;
        this.skucode = skucode;
        this.price = price;
        this.quantity = quantity;
    }

    private String skucode;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private String price;
    private Integer quantity;
}

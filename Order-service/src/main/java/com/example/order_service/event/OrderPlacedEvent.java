package com.example.order_service.event;


public class OrderPlacedEvent {
    private String orderNumber;

    public OrderPlacedEvent() {
    }

    public OrderPlacedEvent(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}

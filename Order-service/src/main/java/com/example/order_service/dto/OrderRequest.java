package com.example.order_service.dto;

import java.util.List;

public class OrderRequest {

    public OrderRequest() {
    }

    private List<OrderLineItemsdto> orderLineItemsDtoList;
    public OrderRequest(List<OrderLineItemsdto> orderLineItemsDtoList) {
        this.orderLineItemsDtoList = orderLineItemsDtoList;

    }
    public List<OrderLineItemsdto> getOrderLineItemsDtoList() {
        return orderLineItemsDtoList;
    }

}

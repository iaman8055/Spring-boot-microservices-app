package com.example.order_service.model;


import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name="t_order")


public class Order {
    public Order() {
    }

    public Order(Long id, String orderNumber, List<OrderLineItems> orderLineItemList) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderLineItemList = orderLineItemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderLineItems> getOrderLineItemList() {
        return orderLineItemList;
    }

    public void setOrderLineItemList(List<OrderLineItems> orderLineItemList) {
        this.orderLineItemList = orderLineItemList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemList;

}

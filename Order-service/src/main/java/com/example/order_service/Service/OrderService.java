package com.example.order_service.Service;

import com.example.order_service.Repository.OrderRepository;
import com.example.order_service.dto.OrderLineItemsdto;
import com.example.order_service.dto.OrderRequest;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderLineItems;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems=orderRequest
                .getOrderLineItemsDtoList()
                .stream()
                .map(this::maptoDto)
                .toList();
        order.setOrderLineItemList(orderLineItems);
        orderRepository.save(order);
    }

    private OrderLineItems maptoDto(OrderLineItemsdto orderLineItemsdto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsdto.getPrice());
        orderLineItems.setSkucode(orderLineItemsdto.getSkucode());
        orderLineItems.setQuantity(orderLineItemsdto.getQuantity());
        return orderLineItems;
    }
}

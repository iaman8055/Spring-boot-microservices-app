package com.example.order_service.Service;

import com.example.order_service.Repository.OrderRepository;
import com.example.order_service.dto.InventoryResponse;
import com.example.order_service.dto.OrderLineItemsdto;
import com.example.order_service.dto.OrderRequest;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderLineItems;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    public OrderService(OrderRepository orderRepository, WebClient.Builder webClientBuilder) {
        this.orderRepository = orderRepository;
        this.webClientBuilder = webClientBuilder;
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

        List<String>skucodes= order.getOrderLineItemList().stream().map(OrderLineItems::getSkucode).toList();
        System.out.println(
                "SKUCODE:"+skucodes
        );
       InventoryResponse[] InventoryArray = webClientBuilder.build().get()
                        .uri("http://inventory-service/api/inventory",uriBuilder -> uriBuilder.queryParam("skucode",skucodes).build())
                        .retrieve()
                        .bodyToMono(InventoryResponse[].class)
                         .block();

        System.out.println("Product:"+InventoryArray);
       Boolean instock= Arrays.stream(InventoryArray).allMatch(InventoryResponse::inStock);
       if(instock){
           orderRepository.save(order);

       }
       else{
           throw new IllegalArgumentException("Product is not in store");
       }

    }

    private OrderLineItems maptoDto(OrderLineItemsdto orderLineItemsdto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsdto.getPrice());
        orderLineItems.setSkucode(orderLineItemsdto.getSkucode());
        orderLineItems.setQuantity(orderLineItemsdto.getQuantity());
        return orderLineItems;
    }
}

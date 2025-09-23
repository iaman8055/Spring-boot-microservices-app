package com.example.order_service.Controller;


import com.example.order_service.Service.OrderService;
import com.example.order_service.dto.OrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class orderController {
    private final OrderService orderService;

    public orderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order Created Successfully";
    }

}

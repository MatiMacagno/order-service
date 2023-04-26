package com.store.orderservice.controller;

import com.store.orderservice.dto.OrderRequest;
import com.store.orderservice.model.Order;
import com.store.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping List<Order> getOrders(){
        return orderService.allOrders();
    }

}

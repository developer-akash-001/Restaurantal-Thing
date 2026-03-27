package com.example.FoodApplicationBackend.auth.controller;

import com.example.FoodApplicationBackend.auth.entity.Order;
import com.example.FoodApplicationBackend.auth.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String placeOrder(Principal principal) {
        orderService.placeOrder(principal.getName());
        return "Order placed";
    }

    @GetMapping("/user")
    public List<Order> getUserOrders(Principal principal) {
        return orderService.getOrders(principal.getName());
    }
}
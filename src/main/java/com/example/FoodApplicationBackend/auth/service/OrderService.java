package com.example.FoodApplicationBackend.auth.service;

import com.example.FoodApplicationBackend.auth.entity.Order;
import com.example.FoodApplicationBackend.auth.entity.User;
import com.example.FoodApplicationBackend.auth.repository.OrderRepository;
import com.example.FoodApplicationBackend.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final UserRepository userRepo;

    public void placeOrder(String mobile) {
        User user = userRepo.findByMobile(mobile)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setOrderTime(LocalDateTime.now());

        orderRepo.save(order);
    }

    public List<Order> getOrders(String mobile) {
        User user = userRepo.findByMobile(mobile)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return orderRepo.findByUser(user);
    }
}
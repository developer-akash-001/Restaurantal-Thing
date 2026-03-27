package com.example.FoodApplicationBackend.auth.repository;

import com.example.FoodApplicationBackend.auth.entity.Order;
import com.example.FoodApplicationBackend.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
package com.example.FoodApplicationBackend.auth.repository;

import com.example.FoodApplicationBackend.auth.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

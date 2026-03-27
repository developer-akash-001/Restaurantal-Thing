package com.example.FoodApplicationBackend.auth.controller;

import com.example.FoodApplicationBackend.auth.entity.MenuItem;
import com.example.FoodApplicationBackend.auth.entity.Restaurant;
import com.example.FoodApplicationBackend.auth.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {


    @Autowired
    private RestaurantService service;

    @GetMapping
    public List<Restaurant> getAll() {
        return service.getAllRestaurants();
    }

    @GetMapping("/{id}/menu")
    public List<MenuItem> getMenu(@PathVariable Long id) {
        return service.getMenuByRestaurant(id);
    }
}

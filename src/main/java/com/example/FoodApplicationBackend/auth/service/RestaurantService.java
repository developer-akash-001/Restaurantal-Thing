package com.example.FoodApplicationBackend.auth.service;

import com.example.FoodApplicationBackend.auth.entity.MenuItem;
import com.example.FoodApplicationBackend.auth.entity.Restaurant;
import com.example.FoodApplicationBackend.auth.repository.MenuItemRepository;
import com.example.FoodApplicationBackend.auth.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private MenuItemRepository menuRepo;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public List<MenuItem> getMenuByRestaurant(Long id) {
        return menuRepo.findByRestaurantId(id);
    }
}

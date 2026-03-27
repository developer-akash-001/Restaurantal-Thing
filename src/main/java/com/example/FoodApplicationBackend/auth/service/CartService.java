package com.example.FoodApplicationBackend.auth.service;

import com.example.FoodApplicationBackend.auth.entity.CartItem;
import com.example.FoodApplicationBackend.auth.entity.MenuItem;
import com.example.FoodApplicationBackend.auth.entity.User;
import com.example.FoodApplicationBackend.auth.repository.CartRepository;
import com.example.FoodApplicationBackend.auth.repository.MenuItemRepository;
import com.example.FoodApplicationBackend.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepo;
    private final MenuItemRepository menuRepo;
    private final UserRepository userRepo;

    public void addToCart(String mobile, Long menuId, int quantity) {
        User user = userRepo.findByMobile(mobile)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MenuItem menuItem = menuRepo.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        CartItem item = new CartItem();
        item.setUser(user);
        item.setMenuItem(menuItem);
        item.setQuantity(quantity);

        cartRepo.save(item);
    }

    public List<CartItem> getCart(String mobile) {
        User user = userRepo.findByMobile(mobile)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartRepo.findByUser(user);
    }
}
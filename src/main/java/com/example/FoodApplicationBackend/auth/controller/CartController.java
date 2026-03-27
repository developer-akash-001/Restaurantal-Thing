package com.example.FoodApplicationBackend.auth.controller;

import com.example.FoodApplicationBackend.auth.entity.CartItem;
import com.example.FoodApplicationBackend.auth.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long menuId,
                            @RequestParam int quantity,
                            Principal principal) {

        cartService.addToCart(principal.getName(), menuId, quantity);
        return "Added to cart";
    }

    @GetMapping
    public List<CartItem> getCart(Principal principal) {
        return cartService.getCart(principal.getName());
    }
}
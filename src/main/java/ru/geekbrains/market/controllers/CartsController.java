package ru.geekbrains.market.controllers;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.market.dto.Cart;
import ru.geekbrains.market.services.CartService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartsController {
    private final CartService cartService;

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/add/{id}")
    public void addProductToCart(@PathVariable Long id) {
        cartService.addProductByIdToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.getCurrentCart().clear();
    }


    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable Long id) {
        cartService.removeProductByIdToCart(id);
    }
}

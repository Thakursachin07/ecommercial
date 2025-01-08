package com.example.Frontend.controller;

import com.example.Frontend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    private final WebClient webClient;

    public CartController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082/cart").build();
    }


    @PostMapping("/saveCart")
    public Mono<String> saveCart(@RequestParam int productId, @RequestParam(defaultValue = "1") int userId) {
        return this.webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/addToCart")
                        .queryParam("productId", productId)
                        .queryParam("userId", userId)
                        .build())
                .retrieve()
                .bodyToMono(String.class) // Ya response ke type ke hisaab se update karein
                .doOnNext(response -> System.out.println("Response from backend: " + response))
                .then(Mono.just("redirect:/"));
    }


    // getAll cart
    @GetMapping("/get-all")
    public Mono<String> viewCarts(Model model) {
        return cartService.getAllCarts()
                .doOnNext(carts -> model.addAttribute("carts", carts))
                .thenReturn("list-carts");
    }

    //remove=======================
    @GetMapping("/deleteCart")
    public Mono<String> removeCarts(@RequestParam int cartId) {
        return cartService.deleteCarts(cartId)
                .thenReturn("redirect:/carts/get-all");

    }

    @GetMapping("/deleteAllCart")
    public Mono<String> removeCarts() {
        return cartService.deleteAllCarts()
                .thenReturn("redirect:/carts/get-all");

    }

}


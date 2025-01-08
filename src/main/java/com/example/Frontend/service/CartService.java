package com.example.Frontend.service;

import com.example.Frontend.entity.Cart;
import com.example.Frontend.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CartService {


    private final WebClient webClient;

    public CartService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082/cart").build();
    }


    public Mono<List<Cart>> getAllCarts()
    {
        Mono<List<Cart>> listMono = this.webClient
                .get()
                .uri("/get-all")
                .retrieve()
                .bodyToFlux(Cart.class)
                .collectList();
        listMono.subscribe(data->{
            System.out.println("data: " +data);
        });
        return listMono;
    }

    public Mono<Void> deleteCarts(int cartId) {
        return this.webClient
                .delete()
                .uri(uriBuilder -> uriBuilder.path("/remove")
                        .queryParam("id", cartId) // Add the productId as a query parameter
                        .build())
                .retrieve()
                .bodyToMono(Void.class) // Expect no response body
                .doOnSuccess(unused -> System.out.println("Cart deleted successfully for productId: " + cartId))
                .doOnError(error -> System.err.println("Error deleting cart for productId " + cartId + ": " + error.getMessage()));
    }

    public Mono<Void> deleteAllCarts() {
        return this.webClient
                .delete()
                .uri(uriBuilder -> uriBuilder.path("/remove-all")
                        .build())
                .retrieve()
                .bodyToMono(Void.class) // Expect no response body
                .doOnSuccess(unused -> System.out.println(" Cart deleted successfully "))
                .doOnError(error -> System.err.println("Error deleting cart for  " + ": " + error.getMessage()));
    }

}

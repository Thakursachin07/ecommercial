package com.example.Frontend.service;

import com.example.Frontend.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082/product").build();
    }


    public Mono<List<Product>> getAllProducts()
    {
        return  this.webClient
                .get()
                .uri("/get-all")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                ;
    }

    public  Mono<Product> getById(int productId)
    {
        return this.webClient
                .get().uri(uriBuilder -> uriBuilder
                        .path("/product-by-id")
                        .queryParam("productId",productId)
                        .build())
                .retrieve()
                .bodyToMono(Product.class);
    }


}

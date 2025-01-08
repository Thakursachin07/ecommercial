/*
package com.example.Frontend.controller;


import com.example.Frontend.entity.UsersController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
public class ProductIntegrate {


    private final WebClient webClient;

    public ProductIntegrate(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }

    @PostMapping("/saveUser")
    public Mono<String> register(UsersController userDtls) {
        return webClient.post()
                .uri("/saveUser")
                .bodyValue(userDtls)
                .retrieve()
                .bodyToMono(Void.class)
                .then(Mono.just("index")); // Return Mono with "index"
    }
}
*/

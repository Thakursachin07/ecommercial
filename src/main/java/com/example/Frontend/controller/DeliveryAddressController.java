package com.example.Frontend.controller;

import com.example.Frontend.entity.DeliveryAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/delivery-address")
public class DeliveryAddressController {

    private WebClient webClient;

    DeliveryAddressController(WebClient.Builder webClientBuilder)
    {
        this.webClient = webClientBuilder.baseUrl("https://ecommercial-production.up.railway.app/delivery-address").build();
    }

    @GetMapping("/")
    public String deliveryAddressForm()
    {
        return "deliveryAddress";
    }


    @PostMapping("/add")
    public Mono<String> userRegister(@ModelAttribute DeliveryAddress deliveryAddress, Model model)
    {
      //  model.addAttribute("message","registration  successful");

        return   webClient.post()
                .uri("/add-address")
                .bodyValue(deliveryAddress)
                .retrieve()
                .bodyToMono(Void.class)
                .thenReturn("redirect:/payment/");



    }
}

package com.example.Frontend.controller;


import com.example.Frontend.entity.UserDtls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RequestMapping("/user")
@Controller
public class UsersController {

    private WebClient webClient;

    UsersController(WebClient.Builder webClientBuilder)
    {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082/users").build();
    }


    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/register")
    public  String register()
    {
        return "register";
    }

    @PostMapping("/saveUser")
    public Mono<String> userRegister(@ModelAttribute UserDtls userDtls, Model model)
    {
        model.addAttribute("message","registration  successful");

       return   webClient.post()
                .uri("/save-userDtls")
                .bodyValue(userDtls)
                .retrieve()
                .bodyToMono(Void.class)
                .thenReturn("register");


    }



}

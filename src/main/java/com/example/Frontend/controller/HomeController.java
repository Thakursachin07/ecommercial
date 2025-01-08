package com.example.Frontend.controller;

import com.example.Frontend.entity.Product;
import com.example.Frontend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
   private ProductService productService;

    @GetMapping("/")
    public String getAllProducts(Model model) {
        Mono<List<Product>> products =  productService.getAllProducts();

        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product-by-id")
    public String viewProductById(@RequestParam int productId,Model model)
    {
        Mono<Product> productMono = productService.getById(productId);

        model.addAttribute("product", productMono);
        return "product-view";

    }

}

package com.example.Frontend.controller;

import com.example.Frontend.entity.Product;
import com.example.Frontend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    private WebClient webClient;

    AdminController(WebClient.Builder webClientBuilder)
    {
        this.webClient = webClientBuilder.baseUrl("https://ecommercial-production.up.railway.app/product").build();
    }


    //============================ PRODUCT START  ================================
    @GetMapping("/")
    public String viewProduct(Model model)
    {
        Mono<List<Product>> products = adminService.getAdminProduct();
       model.addAttribute("products",products);
        System.out.println(products);
       return "admin/product";
    }

    @GetMapping("/add-product-page")
    public String addProduct()
    {
        return "admin/add-product-page";
    }

   /* @PostMapping("/saveProduct")
    public Mono<String> saveProduct(@ModelAttribute Product product,
                                    @RequestPart("file") Mono<FilePart> filePartMono) {
        return filePartMono
                .flatMap(filePart -> adminService.saveProduct(product, filePart))
                .then(Mono.just("redirect:/admin/"));
    }*/

    @PostMapping("/saveProduct")
    public Mono<String> saveProduct(
            @ModelAttribute Product product,
            @RequestPart("file") Mono<FilePart> singleFileMono,
            @RequestPart("files") Flux<FilePart> multipleFilesFlux
    ) {
        return singleFileMono.flatMap(singleFile ->
                multipleFilesFlux.collectList()
                        .flatMap(multipleFiles ->
                                adminService.saveProduct(product, singleFile, multipleFiles)
                        )
                        .then(Mono.just("redirect:/admin/"))
        );
    }




    @DeleteMapping("/deleteAllProduct")
    public Mono<String> deleteAllProduct()
    {
        return adminService.deleteAllProducts()
                .thenReturn("redirect:/admin/");

    }

    @RequestMapping("/delete")
    public Mono<String> deleteProductById(@RequestParam int productId)
    {
        return adminService.deleteById(productId)
                .thenReturn("redirect:/admin/");
    }

    //============================ PRODUCT END ==========================================================


}

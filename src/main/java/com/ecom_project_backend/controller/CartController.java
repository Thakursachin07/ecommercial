package com.ecom_project_backend.controller;

import com.ecom_project_backend.entity.Cart;
import com.ecom_project_backend.repository.CartRepository;
import com.ecom_project_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;


    @PostMapping("/addToCart")
    public List<Cart> addToCard1(@RequestParam int productId, @RequestParam int userId) {
        return cartService.saveCart(productId, userId);

    }

    @GetMapping("/get-all")
    public List<Cart> getAll()
    {

        List<Cart> all = cartService.getAll();
        System.out.println(all);
        return all;
    }

    @DeleteMapping("/remove")
    public void Delete(@RequestParam int id)
    {
        cartService.removeCart(id);
    }

    @DeleteMapping("/subtract-quentity/{id}")
    public void subtractProductQuentity(@PathVariable int id)
    {
        cartService.subtract_product_quentity(id);
    }

    @DeleteMapping("/remove-all")
    public void CartDelete()
    {
        cartService.allDelete();
    }


}

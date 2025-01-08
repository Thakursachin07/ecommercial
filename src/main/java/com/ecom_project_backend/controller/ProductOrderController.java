package com.ecom_project_backend.controller;

import com.ecom_project_backend.entity.ProductOrder;
import com.ecom_project_backend.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-order")
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping("/get-all-product-order")
    public List<ProductOrder> getAllProductOrder()
    {
        System.out.println("get All product order controller");
        return productOrderService.getAllProductOrder();
    }

    @GetMapping("/get-product-order/{id}")
    public Optional<ProductOrder> getProductOrderById(@PathVariable int id)
    {

        return productOrderService.getProductOrderById(id);

    }

    @PostMapping("/save-product-order")
    public ProductOrder saveProductOrder(  @RequestParam int productId,@RequestParam int userId)
    {
        return productOrderService.saveProductOrder(productId,userId);
    }

    @DeleteMapping("/delete-product-order/{id}")
    private void DeleteProductOrderByid(@PathVariable int id)
    {
         productOrderService.DeleteProductOrderByid(id);
    }


}

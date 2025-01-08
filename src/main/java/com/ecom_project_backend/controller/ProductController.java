package com.ecom_project_backend.controller;


import com.ecom_project_backend.entity.Product;
import com.ecom_project_backend.service.ProductService;
import com.ecom_project_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private UserService userService;


    //====================================
   /* @GetMapping("/getAll-product")
    public List<Product> getAllTest() {
        List<Product> allProducts = productService.getAllProducts();
        if (allProducts.size() < 15) {
            List<Product> allProducts1 = productService.getAllProducts();
            // Combine the two lists
            List<Product> combinedList = new ArrayList<>(allProducts);
            combinedList.addAll(allProducts1);

            return combinedList;
        }
        else {
            return allProducts;
        }
    }*/

    //=======================================

    @GetMapping("/get-all")
    public List<Product> getAllProduct()
    {
        List<Product> allProducts = productService.getAllProducts();
        return allProducts;
    }

    @GetMapping("/product-by-id")
    public Optional<Product> getProductByid(@RequestParam int productId)
    {
        return productService.getProductById(productId);
    }

    /*@PostMapping("/save-product")
    public Product saveProduct(@RequestPart("product") Product product,
                               @RequestPart("file") MultipartFile file) {
        return productService.saveProduct(product, file);
    }*/

    //=========================
    @PostMapping("/save-product")
    public Product saveProduct(@RequestPart("product") Product product,
                               @RequestPart("file") MultipartFile file,
                               @RequestParam("files") List<MultipartFile> files) {
        System.out.println("Controller - Saving product");
        return productService.saveProduct(product, file, files);
    }


    //========================

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id )
    {
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam int productId)
    {
        productService.deleteProduct(productId);
    }

   /* @DeleteMapping("/delete-all-product")
    public void deleteAllProduct()
    {
        productService.deleteALlProduct();
    }
*/

}

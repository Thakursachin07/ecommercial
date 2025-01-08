package com.ecom_project_backend.service;


import com.ecom_project_backend.entity.Product;
import com.ecom_project_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //======================================
    public Product
    saveProduct(Product product, MultipartFile file,List<MultipartFile> files) {
        try {
            System.out.println("ecom_service");
            // Ensure the directory exists
            String uploadDir = "D:/image-upload";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs(); // Create the directory if it doesn't exist
            }

// Save the file with the full path
            String imagePath = uploadDir + file.getOriginalFilename();
            File imageFile = new File(imagePath);
            file.transferTo(imageFile);

          /*  String uploadDir2 = "D:/image-upload/list-image";
            File directory2 = new File(uploadDir2);
            if (!directory2.exists()) {
                directory2.mkdirs(); // Create the directory if it doesn't exist
            }
// Save the list of  file with the full path
            for(MultipartFile fileorimage : files)
            {
                String imagePath2 = uploadDir2 + fileorimage.getOriginalFilename();
                File imageFile2 = new File(imagePath2);
                fileorimage.transferTo(imageFile2);
            }*/


// Set the file name to the product
            product.setImage(file.getOriginalFilename());
          // for (MultipartFile singleFile : files){product.setImages(List.of(singleFile.getOriginalFilename()));}

//=====================================
            // Calculate the discounted price
            double discountPrice = product.getPrice() * (1 - (product.getDiscount() / 100.0));
            product.setDiscountPrice(discountPrice);

            // Save the product to the database
            return productRepository.save(product);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }
    }


    //===================
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
//==============================


    public Product  updateProduct(Product product ,int id)
    {
        Optional<Product> product1 = productRepository.findById(id);
        if(product1.isPresent()){
            product1.get().setCategory(product.getCategory());
            product1.get().setDescription(product.getDescription());
            product1.get().setDiscount(product.getDiscount());
            product1.get().setDiscountPrice((product.getPrice())-((product.getPrice() / 100) * product.getDiscount()));

            product1.get().setPrice(product.getPrice());
            product1.get().setStock(product.getStock());
            product1.get().setTitle(product.getTitle());

            return productRepository.save(product1.get());

        }
        return new Product();
    }

    //==================
    public void deleteProduct(int id)
    {
        productRepository.deleteById(id);
    }
    //=================
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

}

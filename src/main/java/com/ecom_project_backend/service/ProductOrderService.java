package com.ecom_project_backend.service;

import com.ecom_project_backend.entity.Product;
import com.ecom_project_backend.entity.ProductOrder;
import com.ecom_project_backend.entity.User;
import com.ecom_project_backend.repository.DeliveryAddressRepository;
import com.ecom_project_backend.repository.ProductOrderRepository;
import com.ecom_project_backend.repository.ProductRepository;
import com.ecom_project_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeliveryAddressRepository orderAddressRepository;

    public List<ProductOrder> getAllProductOrder() {
        return productOrderRepository.findAll();
    }

    public Optional<ProductOrder> getProductOrderById(int id) {
        return productOrderRepository.findById(id);
    }


    public ProductOrder saveProductOrder( int productId, int userId) {
        Product product = productRepository.findById(productId).get();
        User user = userRepository.findById(userId).get();
        ProductOrder productOrder = productOrderRepository.findByProductIdAndUserId(productId, userId);

        ProductOrder productOrder1 = null;
        if (ObjectUtils.isEmpty(productOrder)) {
            productOrder1 = new ProductOrder();
            productOrder1.setOrderDate(LocalDate.now());
            productOrder1.setPaymentType("paytm");
            productOrder1.setStatus("order successfully completed");
            productOrder1.setProduct(product);
            productOrder1.setUsers(user);

        }

        return productOrderRepository.save(productOrder1);

    }


    public void DeleteProductOrderByid(int id) {

        productOrderRepository.deleteById(id);
    }
}

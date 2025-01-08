package com.ecom_project_backend.service;

import com.ecom_project_backend.entity.Cart;
import com.ecom_project_backend.entity.Product;
import com.ecom_project_backend.entity.User;
import com.ecom_project_backend.repository.CartRepository;
import com.ecom_project_backend.repository.ProductRepository;
import com.ecom_project_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<Cart> saveCart(Integer productId, Integer userId) {

        User userDtls = userRepository.findById(userId).get();
        Product product = productRepository.findById(productId).get();

        Cart cartStatus = cartRepository.findByProductIdAndUserId(productId, userId);

        Cart cart = null;

        if (ObjectUtils.isEmpty(cartStatus)) {
            cart = new Cart();
            cart.setProduct(product);
            cart.setUser(userDtls);
            cart.setQuantity(1);
            cart.setTotalPrice(1 * product.getDiscountPrice());
        } else {
            cart = cartStatus;
            cart.setQuantity(cart.getQuantity() + 1);
        }
        List<Cart> saveCart = cartRepository.saveAll(List.of(cart));

        return saveCart;

    }
    public List<Cart>  getAll()
    {

        return  cartRepository.findAll();
    }


    public void removeCart(int id)
    {
        cartRepository.deleteById(id);
    }

    public void subtract_product_quentity(int id)
    {
        Cart cart =cartRepository.findById(id).get();
        if(cart.getQuantity()>=1) {
            cart.setQuantity(cart.getQuantity() - 1);
        }
        cartRepository.save(cart);

    }

    public void allDelete()
    {
        System.out.println("delete");
        cartRepository.deleteAll();
    }


}

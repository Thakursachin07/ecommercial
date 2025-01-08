package com.ecom_project_backend.repository;

import com.ecom_project_backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    Cart findByProductIdAndUserId(int productId,int UserId);

}

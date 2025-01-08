package com.ecom_project_backend.repository;

import com.ecom_project_backend.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductOrderRepository extends JpaRepository<ProductOrder,Integer> {
  @Query("SELECT po FROM ProductOrder po JOIN po.users u WHERE po.product.id = :productId AND u.id = :userId")
  ProductOrder findByProductIdAndUserId(@Param("productId") int productId, @Param("userId") int userId);

}

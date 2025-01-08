package com.ecom_project_backend.repository;

import com.ecom_project_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

     User findByEmail(String email);
}

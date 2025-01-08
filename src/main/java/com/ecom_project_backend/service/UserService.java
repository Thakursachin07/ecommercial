package com.ecom_project_backend.service;


import com.ecom_project_backend.entity.User;
import com.ecom_project_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser()
    {
      return   userRepository.findAll();
    }

    public User getUser(int id)
    {
        return userRepository.findById(id).get();
    }

    public User saveUser(User users)
    {
        users.setRole("USER");
        return userRepository.save(users);
    }

    public User updateUser(int id, User user)
    {
        User userdtls = userRepository.findById(id).get();

        userdtls.setName(user.getName());
        userdtls.setEmail(user.getEmail());
        userdtls.setPassword(user.getPassword());
        userdtls.setMobileNumber(user.getMobileNumber());
        userdtls.setRole("USER");

       // userdtls.setAddress(user.getAddress());
        return userdtls;
    }

    public void userDelete(int id)
    {
        userRepository.deleteById(id);
    }

}

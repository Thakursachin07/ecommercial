package com.ecom_project_backend.controller;

import com.ecom_project_backend.entity.User;
import com.ecom_project_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



   @GetMapping("/get-all")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }

    @GetMapping("/get-user")
    public User getUserById(@RequestParam int id)
    {
        return userService.getUser(id);
    }

    @PostMapping("/save-users")
    public void   saveUser(@RequestBody User users)
    {
        userService.saveUser(users);
    }

    @PutMapping("/update-user")
    public User updateUser(@RequestParam int id, @RequestBody User user)
    {
        return userService.updateUser(id, user);
    }

    public void deleteUser(@RequestParam int id)
    {
        userService.userDelete(id);
    }

}

package com.hritvik.EcommerceAPI.controller;

import com.hritvik.EcommerceAPI.model.Address;
import com.hritvik.EcommerceAPI.model.Product;
import com.hritvik.EcommerceAPI.model.User;
import com.hritvik.EcommerceAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user")
    public Iterable<User> getAllUser(){
        return userService.getAllUser();
    }


    @GetMapping("userwithid")
    public User getUserbyid(@RequestParam("id") Long userId)
    {
        return userService.getUserbyid(userId);
    }

    @PostMapping("user")
    public String addUser(@RequestBody @Valid User user)
    {
        return userService.addUser(user);
    }

//    @DeleteMapping("user")
//
//    public String DeleteUser(@RequestParam("id") Long userId)
//    {
//        return userService.DeleteUser(userId);
//    }

}

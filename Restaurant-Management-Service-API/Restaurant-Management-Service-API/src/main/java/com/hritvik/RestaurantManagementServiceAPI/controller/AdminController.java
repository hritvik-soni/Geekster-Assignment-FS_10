package com.hritvik.RestaurantManagementServiceAPI.controller;

import com.hritvik.RestaurantManagementServiceAPI.model.Order;
import com.hritvik.RestaurantManagementServiceAPI.model.User;
import com.hritvik.RestaurantManagementServiceAPI.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AdminController {
    @Autowired
    AdminService adminService;


    @GetMapping("users")
    public List<User> getAllUsers()
    {
        return adminService.getAllUser();
    }



}


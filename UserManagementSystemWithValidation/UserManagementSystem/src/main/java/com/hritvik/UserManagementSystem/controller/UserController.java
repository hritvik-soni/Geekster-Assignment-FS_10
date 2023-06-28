package com.hritvik.UserManagementSystem.controller;


import com.hritvik.UserManagementSystem.model.User;
import com.hritvik.UserManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping(value = "users")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

      @GetMapping("users/search/{userId}")
      public User getUserByUserid(@PathVariable Integer userId){
        return userService.getUserById(userId);
      }

    @PostMapping("users") // add user
     public String addUser(@RequestBody @Valid User user)
    {
        return userService.createUser(user);
    }

    @DeleteMapping("users/delete/{userId}")

    public String DeleteUserById (@PathVariable Integer userId ){

        return userService.DeleteUser(userId);
    }

    @PutMapping("users/{userId}/{userContact}")
    public String UpdateUser(@PathVariable Integer userId,@PathVariable String userContact)
    {
        return userService.updateUserContact(userId,userContact);
    }

}
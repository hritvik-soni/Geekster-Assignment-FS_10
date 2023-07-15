package com.hritvik.RestaurantManagementServiceAPI.controller;

import com.hritvik.RestaurantManagementServiceAPI.model.Order;
import com.hritvik.RestaurantManagementServiceAPI.model.User;
import com.hritvik.RestaurantManagementServiceAPI.model.dto.SignInInput;
import com.hritvik.RestaurantManagementServiceAPI.model.dto.SignUpOutput;
import com.hritvik.RestaurantManagementServiceAPI.service.AuthenticationService;
import com.hritvik.RestaurantManagementServiceAPI.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;



    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @GetMapping("users")
    List<User> getAllPatients()
    {
        return userService.getAllUser();
    }

    @PostMapping("order/food")
    public String orderFood(@RequestBody Order order, String email, String token)
    {

        if(authenticationService.authenticate(email,token)) {
            boolean status = userService.orderFood(order);
            return status ? "Food is ordered":"error occurred during Ordering Food";
        }
        else
        {
            return "Ordering failed because invalid authentication";
        }
    }

    @DeleteMapping("order/cancel")
    public String  cancelAppointment(String email, String token)
    {

        if(authenticationService.authenticate(email,token)) {
            userService.cancelOrder(email);
            return "canceled Order successfully";
        }
        else
        {
            return "Ordering failed because invalid authentication";
        }
    }
}

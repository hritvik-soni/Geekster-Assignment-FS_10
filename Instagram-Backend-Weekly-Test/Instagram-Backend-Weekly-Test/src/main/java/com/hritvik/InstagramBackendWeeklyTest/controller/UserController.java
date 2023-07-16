package com.hritvik.InstagramBackendWeeklyTest.controller;

import com.hritvik.InstagramBackendWeeklyTest.model.Post;
import com.hritvik.InstagramBackendWeeklyTest.model.User;
import com.hritvik.InstagramBackendWeeklyTest.model.dto.SignInInput;
import com.hritvik.InstagramBackendWeeklyTest.model.dto.SignUpOutput;
import com.hritvik.InstagramBackendWeeklyTest.service.AuthenticationService;
import com.hritvik.InstagramBackendWeeklyTest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("user/signup")
    public SignUpOutput signUpInstaUser(@RequestBody User user) {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInInstaUser(@RequestBody @Valid SignInInput signInInput) {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutInstaUser(String email, String token) {
        if (authenticationService.authenticate(email, token)) {
            return userService.sigOutUser(email);
        } else {
            return "Sign out not allowed for non authenticated user.";
        }

    }



}

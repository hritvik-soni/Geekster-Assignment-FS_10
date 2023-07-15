package com.hritvik.RestaurantManagementServiceAPI.service;

import com.hritvik.RestaurantManagementServiceAPI.model.AuthenticationToken;
import com.hritvik.RestaurantManagementServiceAPI.model.Order;
import com.hritvik.RestaurantManagementServiceAPI.model.User;
import com.hritvik.RestaurantManagementServiceAPI.model.dto.SignInInput;
import com.hritvik.RestaurantManagementServiceAPI.model.dto.SignUpOutput;
import com.hritvik.RestaurantManagementServiceAPI.repository.IAuthTokenRepo;

import com.hritvik.RestaurantManagementServiceAPI.repository.IFoodItemRepo;
import com.hritvik.RestaurantManagementServiceAPI.repository.IUserRepo;
import com.hritvik.RestaurantManagementServiceAPI.service.utils.EmailUtility;
import com.hritvik.RestaurantManagementServiceAPI.service.utils.HashingUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    IUserRepo userRepo;
    @Autowired
    IAuthTokenRepo authTokenRepo;

    @Autowired
    OrderService orderService;

    @Autowired
    IFoodItemRepo foodItemRepo;

    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }


        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = HashingUtility.encryptPassword(user.getUserPassword());



            user.setUserPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(signUpStatus, "user registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }
     public List<User> getAllUser() {
        return userRepo.findAll();
    }


    public String signInUser(SignInInput signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }


        User existingUser = userRepo.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = HashingUtility.encryptPassword(signInInput.getPassword());
            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                authTokenRepo.save(authToken);

                EmailUtility.sendEmail(signInEmail,"email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }
    public String sigOutUser(String email) {

        User user = userRepo.findFirstByUserEmail(email);
        authTokenRepo.delete(authTokenRepo.findFirstByUser(user));
        return "Patient Signed out successfully";
    }

    public boolean orderFood(Order order) {
         Long foodItemId = order.getUser().getUserId();
        boolean isFoodItemValid = foodItemRepo.existsById(foodItemId);

        Long userId = order.getUser().getUserId();
        boolean isUserValid = userRepo.existsById(userId);

        if(isFoodItemValid&& isUserValid)
        {
            orderService.saveOrder(order);
            return true;
        }
        else {
            return false;
        }
    }

    public void cancelOrder(String email) {

        User user = userRepo.findFirstByUserEmail(email);

        Order order = orderService.getOrderForUser(user);

        orderService.cancelOrder(order);
    }

}

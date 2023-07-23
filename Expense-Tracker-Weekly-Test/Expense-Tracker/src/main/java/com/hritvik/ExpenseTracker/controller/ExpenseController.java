package com.hritvik.ExpenseTracker.controller;

import com.hritvik.ExpenseTracker.model.Expense;
import com.hritvik.ExpenseTracker.model.dto.ExpenseOutput;
import com.hritvik.ExpenseTracker.model.dto.ExpenseRequest;
import com.hritvik.ExpenseTracker.model.dto.SignUpOutput;
import com.hritvik.ExpenseTracker.model.dto.UserRequest;
import com.hritvik.ExpenseTracker.service.AuthenticationService;
import com.hritvik.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("expense/create")
    public ExpenseOutput createExpense (@RequestBody ExpenseRequest expenseRequest ,
                                        @RequestParam String email ,
                                        @RequestParam String token)  {

        if (authenticationService.authenticate(email, token)) {

            return expenseService.createExpense(email,expenseRequest);

        } else {
            return ExpenseOutput.builder()
                    .expenseStatus(false)
                    .expenseStatusMessage("Sign out not allowed for non authenticated user.")
                    .build();
        }
    }

    @GetMapping("expenses")
    public ExpenseOutput generateExpense(@RequestParam String email ,
                                         @RequestParam String token,
                                           @RequestParam String startDate ,
                                           @RequestParam String endDate) {

        if (authenticationService.authenticate(email, token)) {

            return expenseService.generateExpense(email, startDate, endDate);

        } else {
            return ExpenseOutput.builder()
                    .expenseStatus(false)
                    .expenseStatusMessage("Sign out not allowed for non authenticated user.")
                    .build();
        }
    }
    @GetMapping("total")
    public ExpenseOutput generateTotalExpense(@RequestParam String email , @RequestParam String token){
        if (authenticationService.authenticate(email, token)) {

            return expenseService.generateTotalExpense(email);

        } else {
            return ExpenseOutput.builder()
                    .expenseStatus(false)
                    .expenseStatusMessage("Sign out not allowed for non authenticated user.")
                    .build();
        }

    }




}

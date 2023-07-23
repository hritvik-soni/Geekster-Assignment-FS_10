package com.hritvik.ExpenseTracker.service;

import com.hritvik.ExpenseTracker.model.Expense;
import com.hritvik.ExpenseTracker.model.User;
import com.hritvik.ExpenseTracker.model.dto.EmailDetails;
import com.hritvik.ExpenseTracker.model.dto.ExpenseOutput;
import com.hritvik.ExpenseTracker.model.dto.ExpenseRequest;
import com.hritvik.ExpenseTracker.repository.IExpenseRepo;
import com.hritvik.ExpenseTracker.repository.IUserRepo;
import com.hritvik.ExpenseTracker.service.utility.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service

public class ExpenseService {
    @Autowired
    IExpenseRepo iExpenseRepo;

    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    EmailService emailService;


    public ExpenseOutput createExpense(String email, ExpenseRequest expenseRequest) {

        User existingUser = iUserRepo.findFirstByUserEmail(email);

        Expense newExpense = Expense.builder()
                .expenseTitle(expenseRequest.getExpenseTitle())
                .expenseDescription(expenseRequest.getExpenseDescription())
                .expensePrice(expenseRequest.getExpensePrice())
                .user(existingUser)
                .build();

       Expense savedExpense = iExpenseRepo.save(newExpense);

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedExpense.getUser().getUserEmail())
                .subject("ACCOUNT CREATION")
                .messageBody("Congratulations! Your Expense Has been Successfully Created.\nYour Account Details: \n" +
                        "Account Name: " + savedExpense.getUser().getUserFirstName() + " " + savedExpense.getUser().getUserLastName() + "'n")
                .build();
        emailService.sendEmailAlert(emailDetails);

    }


    public ExpenseOutput generateExpense(String email, String startDate, String endDate) {

        LocalDate start =LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end =LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);

        List<Expense> expenseList= iExpenseRepo.findAll().stream()
                .filter(expense ->expense.getUser().getUserEmail().equals(email))
                .filter(expense -> expense.getCreatedAtDate().isEqual(start))
                .filter(expense -> expense.getCreatedAtDate().isEqual(end)).toList();

        User existingUser = iUserRepo.findFirstByUserEmail(email);

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(existingUser.getUserEmail())
                .subject("Expense Report")
                .messageBody("Your Account Details: \n" +
                        "Account Name: " + existingUser.getUserFirstName() + " "
                        + existingUser.getUserLastName()
                        + "\n Your Expense Report from " +startDate + " to " +endDate  +"\n"+ expenseList )
                .build();
        emailService.sendEmailAlert(emailDetails);

        return ExpenseOutput.builder()
                .expenseStatus(true)
                .expenseStatusMessage("Your Expense Report is sent Over Mail")
                .expenseReport(expenseList)
                .build();

    }


    public ExpenseOutput generateTotalExpense(String email) {

        User existingUser = iUserRepo.findFirstByUserEmail(email);
        Long userId = existingUser.getUserId();
        Double totalExpense =0.0;


    }


}

package com.hritvik.ExpenseTracker.model.dto;

import com.hritvik.ExpenseTracker.model.Expense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ExpenseOutput {

    private boolean expenseStatus;
    private String expenseStatusMessage;
    private List<Expense> expenseReport;
    private Double expenseTotal;
}

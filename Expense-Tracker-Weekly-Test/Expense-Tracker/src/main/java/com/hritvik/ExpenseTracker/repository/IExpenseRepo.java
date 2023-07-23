package com.hritvik.ExpenseTracker.repository;

import com.hritvik.ExpenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpenseRepo extends JpaRepository<Expense,Long> {
}

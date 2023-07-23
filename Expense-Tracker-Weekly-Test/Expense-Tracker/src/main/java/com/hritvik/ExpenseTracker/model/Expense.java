package com.hritvik.ExpenseTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    private String expenseTitle;
    private String expenseDescription;
    private Double expensePrice;

    @CreationTimestamp
    private LocalDate createdAtDate;

    @CreationTimestamp
    private LocalTime createdAtTime;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private  User user;

}

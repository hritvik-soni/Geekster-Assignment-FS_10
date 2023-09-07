package com.hritvik.EmployeeManagementSystem.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int employeeId;

    public String firstName;

    public String lastName;

    @Length(min = 10,max = 10,message = "Please enter correct")
    public String phoneNumber;

    @Email(message = "please enter correct email")
    public String email;

    public String jobRole;

    public int salary;

    public String address;
}
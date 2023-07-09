package com.hritvik.EcommerceAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userId;

    @NotBlank(message = "name cannot be blank")
    private String userName;

    @Email(message = "Given email id is invalid")
    private String userEmail;

    @Pattern(regexp = "^(?=.*[!@#$%^&*()\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\d)(?=.*[A-Z]).{6,}$")
    private String userPassword;

    @Size(min = 10,max = 10)
    @Pattern(regexp = "^[0-9]+$")
    private String userContact;










}

package com.hritvik.EcommerceAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "name cannot be blank")
    private String productName;

    @NotBlank(message = "Price cannot be blank")
    private Integer productPrice;

    @NotBlank(message = "Description cannot be blank")
    private String productDescription;

    @Enumerated(EnumType.STRING)
    private Category productCategory;

     @Enumerated(EnumType.STRING)
     private Brand productBrand;
}

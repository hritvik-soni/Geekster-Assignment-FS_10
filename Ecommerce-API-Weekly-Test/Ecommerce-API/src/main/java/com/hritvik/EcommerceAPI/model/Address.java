package com.hritvik.EcommerceAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long addId;
    private String addName;
    private String addLandmark;


    @Size(min = 10,max = 10)
    @Pattern(regexp = "^[0-9]+$")
    private String addContact;

    private String addZipcode;
//    private String addCity;
    private String addState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;
}

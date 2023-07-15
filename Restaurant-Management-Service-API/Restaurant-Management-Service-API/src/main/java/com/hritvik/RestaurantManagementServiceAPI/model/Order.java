package com.hritvik.RestaurantManagementServiceAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")

public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  orderId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_foodItem_id")
    private FoodItem foodItem;

    private LocalDateTime localDateTime;


}

package com.hritvik.EcommerceAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "fk_order_product_table",joinColumns =@JoinColumn(name="fk_order_id"),inverseJoinColumns= @JoinColumn(name ="fk_product_id"))
    private List<Product> product;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;


    private Integer productQuantity;





}

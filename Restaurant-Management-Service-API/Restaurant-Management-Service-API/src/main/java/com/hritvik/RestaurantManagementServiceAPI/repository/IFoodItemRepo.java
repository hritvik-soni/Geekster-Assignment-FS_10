package com.hritvik.RestaurantManagementServiceAPI.repository;

import com.hritvik.RestaurantManagementServiceAPI.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodItemRepo extends JpaRepository<FoodItem,Long> {
}

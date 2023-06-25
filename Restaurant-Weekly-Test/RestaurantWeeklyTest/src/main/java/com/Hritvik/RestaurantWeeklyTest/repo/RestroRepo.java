package com.Hritvik.RestaurantWeeklyTest.repo;


import com.Hritvik.RestaurantWeeklyTest.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class RestroRepo {

    @Autowired
    private  List<Restaurant> restroList;
    public List<Restaurant> getRestro() {
        return restroList;
    }


    public void delete(Restaurant restro) {
        restroList.remove(restro);
    }


}

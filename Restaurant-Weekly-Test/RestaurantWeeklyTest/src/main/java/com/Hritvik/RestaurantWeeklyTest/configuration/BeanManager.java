package com.Hritvik.RestaurantWeeklyTest.configuration;


import com.Hritvik.RestaurantWeeklyTest.model.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;

@Configuration
class BeanManager {

    @Bean
    public List<Restaurant> getInitializedList()
    {
        Restaurant initUser = new Restaurant(0,"Rest1",20,"Italian","9999999999","dmo dmo dmo dmo",10);
        List<Restaurant> initList = new ArrayList<>();
        initList.add(initUser);

        return initList;
    }

}
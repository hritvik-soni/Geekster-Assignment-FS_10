package com.hritvik.UserManagementSystem.configuration;

import com.hritvik.UserManagementSystem.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
class BeanManager {

    @Bean
    public List<User> getInitializedList()
    {
        User initUser = new User(0,"demo","dmo","9999999999","dmo dmo dmo dmo dmo");
        List<User> initList = new ArrayList<>();
        initList.add(initUser);

        return initList;
    }
}


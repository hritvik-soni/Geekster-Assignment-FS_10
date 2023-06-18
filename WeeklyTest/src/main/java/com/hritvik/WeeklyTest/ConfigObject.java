package com.hritvik.WeeklyTest;

import com.hritvik.WeeklyTest.Objects.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConfigObject {
    @Bean("blue")
    public Car getCarObject1() {
        System.out.println("Inside bean method getCarObject1");
        return new Car("Blue");
    }
    @Bean("red")

    public Car getCarObject2() {
        System.out.println("Inside bean method getCarObject2");
        return new Car("Red");
    }
}

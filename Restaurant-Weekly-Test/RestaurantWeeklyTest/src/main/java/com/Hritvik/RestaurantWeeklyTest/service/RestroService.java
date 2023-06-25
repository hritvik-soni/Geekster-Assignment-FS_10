package com.Hritvik.RestaurantWeeklyTest.service;

import com.Hritvik.RestaurantWeeklyTest.model.Restaurant;
import com.Hritvik.RestaurantWeeklyTest.repo.RestroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestroService {

    @Autowired
    RestroRepo restroRepo;
    private Integer restroId;

    public String DeleteRestro(Integer restroId) {
        for (Restaurant restro : getAllRestro()) {
            if (restro.getRestroId().equals(restroId)) {

                restroRepo.delete(restro);

                return "Restaurant removed for restroID:" + restroId;
            }
        }
        return "Restaurant" + restroId + " is not deleted as it doesn't exist";
    }

    public List<Restaurant> getAllRestro() {

        return restroRepo.getRestro();
    }


    public String createRestro(Restaurant restro) {
        List<Restaurant> originalList = getAllRestro();
        originalList.add(restro);
        return "New Restaurant added";
    }


    public Restaurant getRestroById(Integer restroId) {
        this.restroId = restroId;

        for (Restaurant restro : restroRepo.getRestro()) {
            if (restro.getRestroId().equals(restroId)) {
                return restro;
            }
        }
        throw new IllegalStateException("RestroId not found");
    }


    public String updateRestroSpecialty(Integer restroId, String restroSpecialty) {

        for (Restaurant restro : restroRepo.getRestro()) {
            if (restro.getRestroId().equals(restroId)) {
                restro.setRestroSpecialty(restroSpecialty);
                return "Restaurant Specialty updated for Restro ID:" + restroId;
            }
        }

        return "Restaurant not found for restro ID: " + restroId;
    }
}

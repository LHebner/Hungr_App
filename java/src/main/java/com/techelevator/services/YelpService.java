package com.techelevator.services;

import java.util.List;
import com.techelevator.model.Restaurant;
import org.springframework.stereotype.Component;
//import com.techelevator.controller.YelpController;


public interface YelpService {

    Restaurant[] getRestaurantsWithRadius(String zipCode, String category, String radius);

    Restaurant getRestaurantByID(String restaurantID);

}
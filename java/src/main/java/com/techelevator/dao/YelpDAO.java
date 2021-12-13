package com.techelevator.services;

import java.util.List;
import com.techelevator.model.Restaurant;
//import com.techelevator.controller.YelpController;


public interface YelpDAO {

    List<Restaurant> getRestaurantsNoRadius(String zipCode, String category);

    List<Restaurant> getRestaurantsWithRadius(String zipCode, String category, String radius);

    YelpService getRestaurantByID(String restaurantID);

    RestYelpService addRestaurantToList(String show);

}
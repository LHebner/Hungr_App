package com.techelevator.controller;

import com.techelevator.model.Restaurant;
import com.techelevator.services.YelpService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class YelpController {

    private YelpService yelpService;

    public YelpController(YelpService yelpService) {
        this.yelpService = yelpService;
    }

    @RequestMapping(path = "/businesses", method = RequestMethod.GET)
    public Restaurant[] getRestaurants(@RequestHeader String zipCode, @RequestHeader String category,
                                       @RequestHeader String radius) {
        List<Restaurant> restaurantList = null;
        if( radius.equals("") ) {
            restaurantList = yelpService.getRestaurantsNoRadius(zipCode, category);
        } else {
            restaurantList = yelpService.getRestaurantsWithRadius(zipCode, category, radius);
        }
        Restaurant[] restaurantArray = new Restaurant[restaurantList.size()];
        return restaurantList.toArray(restaurantArray);
    }
}
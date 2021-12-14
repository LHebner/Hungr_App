package com.techelevator.controller;

import com.techelevator.model.Restaurant;
import com.techelevator.services.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class YelpController {
    @Autowired
    private YelpService yelpService;

    @RequestMapping(path = "/business", method = RequestMethod.GET)

    public Restaurant[] filterByStateAndCity(@RequestParam String zipCode, @RequestParam(required = false) String category, @RequestParam String radius) {
        System.out.println("it worked?!");
        System.out.println(yelpService);
        return yelpService.getRestaurantsWithRadius(zipCode, category, radius);
  }

    @RequestMapping(path = "/business/", method = RequestMethod.GET)
    public Restaurant getRestaurant() {return yelpService.getRestaurantByID("JNR0sCQ0BMPRbD9bl4hOUA");}
    
}
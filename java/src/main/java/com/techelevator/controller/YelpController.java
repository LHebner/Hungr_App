package com.techelevator.controller;

import com.techelevator.dao.YelpJDBCDAO;
import com.techelevator.model.Restaurant;
import com.techelevator.services.RestYelpService;
import com.techelevator.services.YelpDAO;
import com.techelevator.services.YelpService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class YelpController {

    private YelpDAO yelpDAO;

    public YelpController(YelpDAO yelpDAO) {
        this.yelpDAO = yelpDAO ;
    }

    @RequestMapping(path = "/businesses", method = RequestMethod.GET)
    public Restaurant[] getRestaurants(@RequestHeader String zipCode, @RequestHeader String category,
                                       @RequestHeader String radius) {
        List<Restaurant> restaurantList = null;
        if( radius.equals("") ) {
            restaurantList = yelpDAO.getRestaurantsNoRadius(zipCode, category);
        } else {
            restaurantList = yelpDAO.getRestaurantsWithRadius(zipCode, category, radius);
        }
        Restaurant[] restaurantArray = new Restaurant[restaurantList.size()];
        return restaurantList.toArray(restaurantArray);
    }
    @ResponseStatus
    @RequestMapping(value = "/business/add", method = RequestMethod.POST)
//    public void addShow(@Valid @RequestBody AnimeList animeList)
    public RestYelpService addRestaurant(@Valid @RequestBody Restaurant newInvite) {
//        if (!animeDao.addShowToMyList(newshow.getTitle())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Its late lol");
        return yelpDAO.addRestaurantToList(newInvite.getName());
    }
}
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

//    public YelpController(YelpDAO yelpDAO) {
//        this.yelpDAO = yelpDAO ;
//    }

    @RequestMapping(path = "/business", method = RequestMethod.GET)
//    public Restaurant[] getRestaurants(@RequestHeader String zipCode, @RequestHeader String category,
//                                       @RequestHeader String radius) {
    public Restaurant[] filterByStateAndCity(@RequestParam String zipCode, @RequestParam(required = false) String category, @RequestParam String radius) {
//        List<Restaurant> restaurantList = new ArrayList<>();
//
//
//        if( radius.equals("") ) {
//            restaurantList = yelpDAO.getRestaurantsNoRadius(zipCode, category);
//        } else {
//            restaurantList = yelpDAO.getRestaurantsWithRadius(zipCode, category, radius);
//        }
//        Restaurant[] restaurantArray = new Restaurant[restaurantList.size()];
        System.out.println("it worked?!");
        System.out.println(yelpService);
        return yelpService.getRestaurantsWithRadius(zipCode, category, radius);
  }

    @RequestMapping(path = "/business/", method = RequestMethod.GET)
    public Restaurant getRestaurant() {return yelpService.getRestaurantByID("JNR0sCQ0BMPRbD9bl4hOUA");}

//    @ResponseStatus
//    @RequestMapping(value = "/business/add", method = RequestMethod.POST)
////    public void addShow(@Valid @RequestBody AnimeList animeList)
//    public RestYelpService addRestaurant(@Valid @RequestBody Restaurant newInvite) {
////        if (!animeDao.addShowToMyList(newshow.getTitle())) {
////            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Its late lol");
//        return yelpDAO.addRestaurantToList(newInvite.getName());
//    }
}
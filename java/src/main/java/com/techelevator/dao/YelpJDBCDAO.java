package com.techelevator.dao;
import java.util.List;

import com.techelevator.services.YelpDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import com.techelevator.model.Restaurant;
import com.techelevator.model.YelpRestaurantsResponse;

@CrossOrigin
@Component
public class YelpJDBCDAO implements YelpDAO {

    private final String BASE_URL = "https://api.yelp.com/v3/";
    private final String TOKEN;
    private RestTemplate restTemplate = new RestTemplate();

    private JdbcTemplate jdbcTemplate;
    public YelpJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public RestYelpService(@Value("${yelp.api.key}") String TOKEN) {
        this.TOKEN = TOKEN;
    }

    @Override
    public List<Restaurant> getRestaurantsNoRadius(String zipCode, String category) {
        YelpRestaurantsResponse response = restTemplate.exchange(BASE_URL +
                        "businesses/search?location={zipCode}&term={category}&limit=10",
                HttpMethod.GET, makeAuthEntity(TOKEN), YelpRestaurantsResponse.class, zipCode, category).getBody();
        return response.getRestaurants();
    }



//    @Override
//    public List<Restaurant> inviteToRestaurant(String zipCode, String category) {
//
//        YelpRestaurantsResponse response = restTemplate.exchange(BASE_URL +
//                        "businesses/search?location={zipCode}&term={category}&limit=10",
//                HttpMethod.POST, makeAuthEntity(TOKEN), YelpRestaurantsResponse.class, zipCode, category).getBody();
//        return response.getRestaurants();
//    }

    @Override
    public List<Restaurant> getRestaurantsWithRadius(String zipCode, String category, String radius) {
        YelpRestaurantsResponse response = restTemplate.exchange(BASE_URL +
                        "businesses/search?location={zipCode}&term={category}&radius={radius}&limit=10",
                HttpMethod.GET, makeAuthEntity(TOKEN), YelpRestaurantsResponse.class, zipCode, category, radius).getBody();
        return response.getRestaurants();
    }

    @Override
    public Restaurant getRestaurantByID(String restaurantID) {
        Restaurant restaurant = restTemplate.exchange(BASE_URL + "businesses/{restaurantID}",
                HttpMethod.GET, makeAuthEntity(TOKEN), Restaurant.class, restaurantID).getBody();
        return restaurant;
    }

    // Headers helper method
    private HttpEntity<String> makeAuthEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }

}
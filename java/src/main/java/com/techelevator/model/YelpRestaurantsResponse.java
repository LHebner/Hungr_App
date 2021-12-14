package com.techelevator.model;

import java.util.List;

public class YelpRestaurantsResponse {

    private Restaurant[] businesses;

    public Restaurant[] getBusinesses() {
        return businesses;
    }

    public void setBusinesses(Restaurant[] businesses) {
        this.businesses = businesses;
    }
}
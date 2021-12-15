package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class RestaurantLocation {

    @JsonProperty("display_address")
    private String[] address;

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return Arrays.toString(address);
    }
}
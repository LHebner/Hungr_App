package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class Restaurant {

    private String id;
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    private String url;
    @JsonProperty("review_count")
    private int reviewCount;
    private RestaurantCategory[] categories;
    private BigDecimal rating;
    private RestaurantLocation location;
    @JsonProperty("display_phone")
    private String displayPhone;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public RestaurantCategory[] getCategories() {
        return categories;
    }

    public void setCategories(RestaurantCategory[] categories) {
        this.categories = categories;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public RestaurantLocation getLocation() {
        return location;
    }

    public void setLocation(RestaurantLocation location) {
        this.location = location;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
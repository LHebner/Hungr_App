package com.techelevator.model;

public class Invite {

    private Long id;
    private int hostId;
    private int attendeeId;
    private int restaurantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    public int getRestaurantIdId() {
        return restaurantId;
    }

    public void setRestaurantIdId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}

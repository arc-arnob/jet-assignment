package com.jet.restaurant.infrastructure.dto;

import java.util.List;

public class RawApiResponse {
    private List<RawRestaurant> restaurants;

    public List<RawRestaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RawRestaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
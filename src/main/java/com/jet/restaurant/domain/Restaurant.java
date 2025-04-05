package com.jet.restaurant.domain;


import java.util.List;
// Core Model/ Core Business Logic
public class Restaurant {
    private String name;
    private List<String> cuisines;
    private double rating;
    private String address;

    public Restaurant(String name, List<String> cuisines, double rating, String address) {
        this.name = name;
        this.cuisines = cuisines;
        this.rating = rating;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public double getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }
}
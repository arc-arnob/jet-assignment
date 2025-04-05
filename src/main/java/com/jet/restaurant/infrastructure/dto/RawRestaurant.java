package com.jet.restaurant.infrastructure.dto;

import java.util.List;

public class RawRestaurant {
    private String name;
    private List<Cuisine> cuisines;
    private Rating rating;
    private String address;

    public String getName() {
        return name;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public Rating getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public static class Cuisine {
        private String name;
        public String getName() {
            return name;
        }
    }

    public static class Rating {
        private double starRating;
        public double getStarRating() {
            return starRating;
        }
    }
}

package com.jet.restaurant.domain;
import java.util.List;

public interface RestaurantDataProvider {
    List<Restaurant> fetchRestaurantsByPostcode(String postcode);
}

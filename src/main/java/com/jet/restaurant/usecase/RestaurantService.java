package com.jet.restaurant.usecase;

import com.jet.restaurant.domain.Restaurant;
import com.jet.restaurant.domain.RestaurantDataProvider;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantDataProvider dataProvider;

    public RestaurantService(RestaurantDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public List<Restaurant> getTopRestaurants(String postcode) {
        List<Restaurant> all = dataProvider.fetchRestaurantsByPostcode(postcode);
        return all.stream().limit(10).toList();
    }
}

package com.jet.restaurant.controller;

import com.jet.restaurant.domain.Restaurant;
import com.jet.restaurant.usecase.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurants(@RequestParam String postcode) {
        return restaurantService.getTopRestaurants(postcode);
    }
}

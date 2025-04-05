package com.jet.restaurant.controller;

import com.jet.restaurant.domain.Restaurant;
import com.jet.restaurant.usecase.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RestaurantViewController {

    private final RestaurantService restaurantService;

    public RestaurantViewController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/view")
    public String showRestaurants(@RequestParam String postcode, Model model) {
        List<Restaurant> restaurants = restaurantService.getTopRestaurants(postcode);
        model.addAttribute("restaurants", restaurants);
        model.addAttribute("postcode", postcode);
        return "index";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}

package com.jet.restaurant.infrastructure;

import com.jet.restaurant.domain.Restaurant;
import com.jet.restaurant.domain.RestaurantDataProvider;
import com.jet.restaurant.infrastructure.dto.RawApiResponse;
import com.jet.restaurant.infrastructure.dto.RawRestaurant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantApiClient implements RestaurantDataProvider {

    private final WebClient webClient;

    @Value("${justeat.api.url:https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/}")
    private String baseUrl;

    public RestaurantApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public List<Restaurant> fetchRestaurantsByPostcode(String postcode) {
        String url = baseUrl + postcode;

        RawApiResponse response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(RawApiResponse.class)
                .block();

        return response.getRestaurants().stream()
                .map(raw -> new Restaurant(
                        raw.getName(),
                        raw.getCuisines().stream().map(RawRestaurant.Cuisine::getName).toList(),
                        raw.getRating().getStarRating(),
                        raw.getAddress().getFirstLine() + ", " +
                                raw.getAddress().getCity() + ", " +
                                raw.getAddress().getPostalCode()
                ))
                .collect(Collectors.toList());
    }
}
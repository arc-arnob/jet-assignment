package com.jet.restaurant.usecase;

import com.jet.restaurant.domain.Restaurant;
import com.jet.restaurant.domain.RestaurantDataProvider;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantServiceTest {
    // ARRANGE, ACT and Assert pattern.
    @Test
    void shouldReturnTop10Restaurants() {
        // Arrange
        RestaurantDataProvider mockProvider = mock(RestaurantDataProvider.class);
        List<Restaurant> dummyList = generateDummyRestaurants(15);

        when(mockProvider.fetchRestaurantsByPostcode("EC4M7RF")).thenReturn(dummyList);

        RestaurantService service = new RestaurantService(mockProvider);

        // Act
        List<Restaurant> top10 = service.getTopRestaurants("EC4M7RF");

        // Assert
        assertEquals(10, top10.size());
        assertEquals("Restaurant 1", top10.get(1).getName());
        verify(mockProvider).fetchRestaurantsByPostcode("EC4M7RF");
    }

    private List<Restaurant> generateDummyRestaurants(int count) {
        return java.util.stream.IntStream.range(0, count)
                .mapToObj(i -> new Restaurant("Restaurant " + i,
                        List.of("Cuisine A", "Cuisine B"), 4.5, "Some Address"))
                .toList();
    }
}

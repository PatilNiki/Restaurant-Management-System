package com.np.restaurantlisting.service;

import java.util.List;

import com.np.restaurantlisting.dto.RestaurantDto;

public interface RestaurantService {

	List<RestaurantDto> fetchAllRestaurants();

	RestaurantDto getRestaurantById(Integer restaurant_id);

	RestaurantDto addRestaurant(RestaurantDto restaurant);


}

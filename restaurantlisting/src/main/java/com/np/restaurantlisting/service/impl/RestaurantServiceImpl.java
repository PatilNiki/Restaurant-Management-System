package com.np.restaurantlisting.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.restaurantlisting.dto.RestaurantDto;
import com.np.restaurantlisting.entity.Restaurant;
import com.np.restaurantlisting.mapper.RestaurantMapper;
import com.np.restaurantlisting.repo.RestaurantRepo;
import com.np.restaurantlisting.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public List<RestaurantDto> fetchAllRestaurants() {
		 List<Restaurant> restaurants = restaurantRepo.findAll();
		return restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant)).collect(Collectors.toList());
	}

	@Override
	public RestaurantDto getRestaurantById(Integer restaurant_id) {
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurantRepo.findById(restaurant_id).orElse(null));
	}

	@Override
	public RestaurantDto addRestaurant(RestaurantDto restaurant) {
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurant)));
	}

}

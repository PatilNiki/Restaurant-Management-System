package com.np.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.np.restaurantlisting.dto.RestaurantDto;
import com.np.restaurantlisting.entity.Restaurant;

@Mapper
public interface RestaurantMapper {
	
	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	
	Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
	
	RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);

}

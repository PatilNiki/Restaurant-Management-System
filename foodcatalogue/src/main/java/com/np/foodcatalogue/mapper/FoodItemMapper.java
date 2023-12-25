package com.np.foodcatalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.np.foodcatalogue.dto.FoodItemDto;
import com.np.foodcatalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {
	
	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
	
	FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);
	
	FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto);

}

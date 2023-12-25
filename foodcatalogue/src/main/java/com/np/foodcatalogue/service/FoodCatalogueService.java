package com.np.foodcatalogue.service;

import com.np.foodcatalogue.dto.FoodCataloguePage;
import com.np.foodcatalogue.dto.FoodItemDto;

public interface FoodCatalogueService {

	FoodItemDto addFoodItem(FoodItemDto foodItemDto);

	FoodCataloguePage getRestaurantAndFoodItemsById(Integer restaurant_id);

}

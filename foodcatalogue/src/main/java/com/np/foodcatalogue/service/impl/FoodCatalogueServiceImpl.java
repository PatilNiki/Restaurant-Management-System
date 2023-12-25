package com.np.foodcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.np.foodcatalogue.dto.FoodCataloguePage;
import com.np.foodcatalogue.dto.FoodItemDto;
import com.np.foodcatalogue.dto.RestaurantDto;
import com.np.foodcatalogue.entity.FoodItem;
import com.np.foodcatalogue.mapper.FoodItemMapper;
import com.np.foodcatalogue.repo.FoodItemRepository;
import com.np.foodcatalogue.service.FoodCatalogueService;

@Service
public class FoodCatalogueServiceImpl implements FoodCatalogueService{
	
	@Autowired
	private FoodItemRepository foodItemRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto)));
	}

	@Override
	public FoodCataloguePage getRestaurantAndFoodItemsById(Integer restaurant_id) {
		
		List<FoodItem> foodItems = fetchFoodItemList(restaurant_id);
		RestaurantDto restaurant = fetchRestaurantDetails(restaurant_id);
		FoodCataloguePage foodCataloguePage = createFoodCateloguePage(foodItems, restaurant);
		
		return foodCataloguePage;
	}
	
	private List<FoodItem> fetchFoodItemList(Integer restaurant_id){
		return foodItemRepository.findByRestaurantId(restaurant_id);
	}
	
	private RestaurantDto fetchRestaurantDetails(Integer restaurant_id) {
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/getRestaurant/"+restaurant_id, RestaurantDto.class);
		
	}
	
	private FoodCataloguePage createFoodCateloguePage(List<FoodItem> foodItems, RestaurantDto restaurant) {
		FoodCataloguePage foodCataloguePageDto = new FoodCataloguePage();
		
		foodCataloguePageDto.setFoodItems(foodItems);
		foodCataloguePageDto.setRestaurant(restaurant);
		return foodCataloguePageDto;
	}

}

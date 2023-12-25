package com.np.foodcatalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.foodcatalogue.dto.FoodCataloguePage;
import com.np.foodcatalogue.dto.FoodItemDto;
import com.np.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {
	
	@Autowired
	private FoodCatalogueService foodCatalogueService;
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItem){
		FoodItemDto foodItemDto = foodCatalogueService.addFoodItem(foodItem);
		return new ResponseEntity<>(foodItemDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/getRestaurantAndFoodItemsById/{restaurant_id}")
	public ResponseEntity<FoodCataloguePage> getRestaurantAndFoodItemsById(@PathVariable Integer restaurant_id){
		FoodCataloguePage foodCataloguePage = foodCatalogueService.getRestaurantAndFoodItemsById(restaurant_id);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
	}

}

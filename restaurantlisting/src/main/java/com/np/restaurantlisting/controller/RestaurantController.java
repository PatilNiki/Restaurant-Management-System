package com.np.restaurantlisting.controller;

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

import com.np.restaurantlisting.dto.RestaurantDto;
import com.np.restaurantlisting.service.RestaurantService;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants(){
		List<RestaurantDto> restaurants= restaurantService.fetchAllRestaurants();
		return new ResponseEntity<>(restaurants, HttpStatus.OK);
	}
	
	@GetMapping("/getRestaurant/{restaurant_id}")
	public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Integer restaurant_id){
		RestaurantDto restaurant= restaurantService.getRestaurantById(restaurant_id);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurant){
		RestaurantDto restaurantDto = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<>(restaurantDto, HttpStatus.CREATED);
	}

}

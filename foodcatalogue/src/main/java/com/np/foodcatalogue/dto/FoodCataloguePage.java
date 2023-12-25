package com.np.foodcatalogue.dto;

import java.util.List;

import com.np.foodcatalogue.entity.FoodItem;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
	private List<FoodItem> foodItems;
	private RestaurantDto restaurant;
	
}

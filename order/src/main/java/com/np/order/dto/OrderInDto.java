package com.np.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInDto {
	private List<FoodItemDto> foodItemList;
	private Integer userId;
	private RestaurantDto restaurant;

}

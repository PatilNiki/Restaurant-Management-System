package com.np.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderOutDto {
	private Integer orderId;
	private List<FoodItemDto> foodItemList;
	private RestaurantDto restaurant;
	private UserDto user;
}

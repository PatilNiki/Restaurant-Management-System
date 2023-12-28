package com.np.order.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.np.order.dto.FoodItemDto;
import com.np.order.dto.RestaurantDto;
import com.np.order.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
	
	@Id
	private Integer orderId;
	
	private List<FoodItemDto> foodItemDtos;
	private RestaurantDto restaurantDto;
	private UserDto userDto;

}
